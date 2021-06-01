package kodlamaio.hrms.business.concretes;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCandidateService;
import kodlamaio.hrms.business.abstracts.VerificationEmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.ActivationCodeGeneratorManager;
import kodlamaio.hrms.core.utilities.verification.ActivationCodeGeneratorService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCandidate;
import kodlamaio.hrms.mernisService.IdentityCheckerService;

@Service
public class AuthManager implements AuthService {
	CandidateService candidateService;
	EmployerService employerService;
//	ActivationCodeGeneratorService
	ActivationCodeGeneratorService activationCodeGeneratorService;
	ActivationCodeService activationCodeService;
	IdentityCheckerService identityCheckerService;
	VerificationCandidateService verifyEmployeeService;
	VerificationEmployerService verifyEmployerService;

	public AuthManager(EmployeeService employeeService, EmployerService employerService,
			ActivationCodeGeneratorService activationCodeGeneratorService, ActivationCodeService activationCodeService,
			IdentityCheckerService identityCheckerService, VerificationCandidateService verifyEmployeeService,
			VerificationEmployerService verifyEmployerService, CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
//		this.activationCodeGeneratorService = activationCodeGeneratorService;
		this.activationCodeGeneratorService = new ActivationCodeGeneratorManager();
		this.activationCodeService = activationCodeService;
		this.identityCheckerService = identityCheckerService;
//		this.verifyEmployeeService = verifyEmployeeService;
		this.verifyEmployerService = verifyEmployerService;
	}

	@Override
	public Result registerWithCandidate(Candidate candidate) {

		Result result = BusinessRules.run(
				fakeMernisControl(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentityNumber(),
						candidate.getBirthYear()),
				isIdentityNumberExist(candidate.getIdentityNumber()));
		if (result != null) {
			return result;
		}

		candidateService.add(candidate);
		String code = activationCodeGeneratorService.verificationLink(candidate.getEmail());
		verificationCodeForEmployees(0,code,true,candidate.getId(), candidate.getEmail());


		return new SuccessResult("Kayıt başarıyla tamamlandı.");
	}

	

	private Result isIdentityNumberExist(String identityNumber) {
		if (this.candidateService.isIdentityNumberExist(identityNumber).isSuccess()) {

			return new SuccessResult();
		}
		return new ErrorResult("Bu Tc kimlik no ile kayıtlı kullanıcı var.");
	}

    
	
private Result fakeMernisControl(String identityNumber, String firstName, String lastName, String birthYear) {
		
		if (this.identityCheckerService.fakeMernisControl(identityNumber,firstName,lastName,birthYear)) {
			return new SuccessResult();
		}
		return new ErrorResult("Doğrulama başarısız.");
	}



	private void verificationCodeForEmployees(int id, String activationCode, boolean isValid,  int candidateId, String email) {

		VerificationCandidate verificationCode = new VerificationCandidate(id,activationCode,isValid, candidateId);
		this.activationCodeService.add(verificationCode);
		System.out.println("Doğrulama maili gönderildi. " + email);

	}


	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public Result registerWithEmployer(Employer employer) {

//		Result result = BusinessRules.run(isRealEmployerEmail(employer),checkNullFieldsForEmployer(employer));

		Result result = BusinessRules.run(checkNullFieldsForEmployer(employer));
		
		if (result != null) {
			return result;
		}
//		this.employerService.add(employer);
		String code = activationCodeGeneratorService.verificationCode();
		verificationCodeForEmployees(0,code,true,employer.getId(), employer.getEmail());
		this.employerService.add(employer);
		return new SuccessResult("Kayıt başarıyla tamamlandı.");
	}

	
//	private Result checkMailAndDomain(String email, String webAddress) {
//		String[] mails = email.split("@", 2);
//		String domain = webAddress.substring(4, webAddress.length());
//		if (mails[1].equals(domain)) {
//			return new SuccessResult();
//		}
//		return new ErrorResult("Mail adresi uzantısı ile web sitesinin alan adı uyuşmuyor.");
//	}
	
	
	
	
	private Result checkNullFieldsForEmployer(Employer employer) {
		
		 if (employer.getCompanyName()!=null && employer.getEmail()!=null 
				 && employer.getPassword()!=null && employer.getPhoneNumber()!=null
				     && employer.getWebAddress()!=null) {
			return new SuccessResult();
		}
		 return new ErrorResult("Lütfen tüm alanları eksiksiz doldurun.");
	}

}
