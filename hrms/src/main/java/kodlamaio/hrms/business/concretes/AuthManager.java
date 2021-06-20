package kodlamaio.hrms.business.concretes;



import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.emailSender.spring.EmailSenderService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.mernisService.IdentityCheckerService;

@Service
public class AuthManager implements AuthService {
	private CandidateService candidateService;
	private EmployerService employerService;
	private ActivationCodeService activationCodeService;
	private IdentityCheckerService identityCheckerService;
	
	
	@Autowired
	EmailSenderService emailSenderService;

	public AuthManager(EmployeeService employeeService, EmployerService employerService,
			ActivationCodeService activationCodeService,
			IdentityCheckerService identityCheckerService,CandidateDao candidateDao, CandidateService candidateService) {
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.activationCodeService = activationCodeService;
		this.identityCheckerService = identityCheckerService;

	}

	@Override
	public Result registerCandidate(Candidate candidate) throws MessagingException {

		Result result = BusinessRules.run(fakeMernisControl(candidate.getFirstName(), candidate.getLastName(),
				candidate.getIdentityNumber(), candidate.getBirthYear()),
				isIdentityNumberExist(candidate.getIdentityNumber()));
		if (result != null) {
			return result;
		}

		
		candidateService.add(candidate);
		String code = activationCodeService.sendCode();
		verificationCodeRecord(code, candidate.getId(), candidate.getEmail());
		emailSenderService.sendEmailWithAttachment(candidate.getEmail(), "Doğrulama Kodunuz : " + code, "HRMS - Human Resources Manager System | Hesap Doğrulama",
				"C:\\Users\\Seyit\\Desktop\\hrms_logo.jpg");
		return new SuccessResult("Doğrulama kodu " + candidate.getEmail() + " email adresine gönderildi");
	}

		private void verificationCodeRecord(String code, int id, String email) {
		
			ActivationCode activationCode = new ActivationCode(id, code, false, LocalDateTime.now());
			this.activationCodeService.save(activationCode);
			
	
	}
	
	private Result isIdentityNumberExist(String identityNumber) {
		if (this.candidateService.isIdentityNumberExist(identityNumber).isSuccess()) {

			return new SuccessResult();
		}
		return new ErrorResult(Message.identityNumberAlreadyRegistered);
	}

	private Result fakeMernisControl(String identityNumber, String firstName, String lastName, String birthYear) {

		if (this.identityCheckerService.fakeMernisControl(identityNumber, firstName, lastName, birthYear)) {
			return new SuccessResult();
		}
		return new ErrorResult(Message.verificationFailed);
	}

	@Override
	public Result registerEmployer(Employer employer) throws MessagingException {

		Result result = BusinessRules.run(checkNullFieldsForEmployer(employer),
				checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress()));

		if (result != null) {
			return result;
		}
		this.employerService.add(employer);
		
		return new SuccessResult(Message.successRegistered);
	}

	private Result checkIfEqualEmailAndDomain(String email, String webAddress) {
		String[] emailArray = email.split("@", 2);
		String domain = webAddress.substring(4,webAddress.length());
		
		if(emailArray[1].equals(domain)) {
			return new SuccessResult();
		}
		return new ErrorResult(Message.emailVerificationFailed);
		
	}

	private Result checkNullFieldsForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getEmail() != null && employer.getPassword() != null
				&& employer.getPhoneNumber() != null && employer.getWebAddress() != null) {
			return new SuccessResult();
		}
		return new ErrorResult(Message.checkNullFields);
	}
	
	


}
