package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.mernisService.IdentityCheckerService;

@Service
public class AuthManager implements AuthService {
	CandidateService candidateService;
	EmployerService employerService;
	ActivationCodeService activationCodeService;
	IdentityCheckerService identityCheckerService;

	public AuthManager(EmployeeService employeeService, EmployerService employerService,
			ActivationCodeService activationCodeService,
			IdentityCheckerService identityCheckerService, CandidateService candidateService) {
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.activationCodeService = activationCodeService;
		this.identityCheckerService = identityCheckerService;

	}

	@Override
	public Result registerCandidate(Candidate candidate) {

		Result result = BusinessRules.run(fakeMernisControl(candidate.getFirstName(), candidate.getLastName(),
				candidate.getIdentityNumber(), candidate.getBirthYear()),
				isIdentityNumberExist(candidate.getIdentityNumber()));
		if (result != null) {
			return result;
		}

		candidateService.add(candidate);

		activationCodeService.sendActivationCode(candidate.getId());
		

	
		
		return new SuccessResult("Kayıt başarıyla tamamlandı.");
	}

	private Result isIdentityNumberExist(String identityNumber) {
		if (this.candidateService.isIdentityNumberExist(identityNumber).isSuccess()) {

			return new SuccessResult();
		}
		return new ErrorResult("Bu Tc kimlik no ile kayıtlı kullanıcı var.");
	}

	private Result fakeMernisControl(String identityNumber, String firstName, String lastName, String birthYear) {

		if (this.identityCheckerService.fakeMernisControl(identityNumber, firstName, lastName, birthYear)) {
			return new SuccessResult();
		}
		return new ErrorResult("Doğrulama başarısız.");
	}

	@Override
	public Result registerEmployer(Employer employer) {

		Result result = BusinessRules.run(checkNullFieldsForEmployer(employer));

		if (result != null) {
			return result;
		}
		this.employerService.add(employer);
		this.activationCodeService.sendActivationCode(employer.getId());
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

		if (employer.getCompanyName() != null && employer.getEmail() != null && employer.getPassword() != null
				&& employer.getPhoneNumber() != null && employer.getWebAddress() != null) {
			return new SuccessResult();
		}
		return new ErrorResult("Lütfen tüm alanları eksiksiz doldurun.");
	}

}
