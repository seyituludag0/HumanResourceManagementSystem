package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.adapters.EmailAdapter;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernisService.IdentityCheckerService;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private IdentityCheckerService identityCheckerService;
	private EmailAdapter emailAdapter;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailAdapter emailAdapter,IdentityCheckerService identityCheckerService) {
		super();
		this.candidateDao = candidateDao;
		this.emailAdapter = emailAdapter;
		this.identityCheckerService = identityCheckerService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
	List<Candidate> candidates = this.candidateDao.findAll();
	if(candidates.isEmpty()) {
		return new ErrorDataResult<>(Message.getNullCandidate);
	}
	return new SuccessDataResult<List<Candidate>>(candidates, Message.getAllCandidate);
}

	@Override
    public Result add(Candidate candidate) {
		if(!identityCheckerService.fakeMernisControl(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentityNumber(),
				candidate.getBirthYear())) {
			return new ErrorResult("Kimlik doğrulanamadı");
		}
		else if (isMailExists(candidate.getEmail())) {
            return new ErrorResult(Message.emailAlreadyRegistered);
        }
		else if (isIdentityNumberExists(candidate.getIdentityNumber())) {
            return new ErrorResult(Message.identityNumberAlreadyRegistered);
        }
		else if (!emailAdapter.sendEmail(candidate.getEmail())) {
            return new ErrorResult("E mail doğrulanmadı");
        }
        candidateDao.save(candidate);
        return new SuccessResult(Message.registered);
    }
	
	

	@Override
	public Result update(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult(Message.updateCandidate);
	}

	@Override
	public Result delete(int id) {
		candidateDao.deleteById(id);
		return new SuccessResult(Message.deleteCandidate);
	}

	private boolean isIdentityNumberExists(String identityNumber) {
        return this.candidateDao.findByIdentityNumber(identityNumber).isPresent();
    }
	
	private boolean isMailExists(String eMail) {
        return this.candidateDao.findByEmail(eMail).isPresent();
    }


	@Override
	public Result isIdentityNumberExist(String identityNumber) {
		if (candidateDao.findByIdentityNumberContaining(identityNumber).isEmpty()) {
			return new SuccessResult();

		} else {
			return new ErrorResult("Bu Tc kimlik no ile kayıtlı kullanıcı var.");
		}
	}
	
}
