package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.entities.concretes.VerificationCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCandidateDao;

@Service
public class VerificationCandidateManager implements VerificationCandidateService {

	private VerificationCandidateDao verificationEmployeeDao;

	@Autowired
	public VerificationCandidateManager(VerificationCandidateDao verificationEmployeeDao) {
		this.verificationEmployeeDao = verificationEmployeeDao;
	}

	@Override
	public Result add(VerificationCandidate candidate) {
		verificationEmployeeDao.save(candidate);
		return new SuccessResult("Kod kaydedildi.");
	}
	
	
}
