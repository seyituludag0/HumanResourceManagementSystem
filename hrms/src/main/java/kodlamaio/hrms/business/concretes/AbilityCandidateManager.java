package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AbilityCandidateDao;
import kodlamaio.hrms.entities.concretes.AbilityCandidate;

@Service
public class AbilityCandidateManager implements AbilityCandidateService{

	private AbilityCandidateDao abilityCandidateDao;

	@Autowired
	public AbilityCandidateManager(AbilityCandidateDao abilityCandidateDao) {
		super();
		this.abilityCandidateDao = abilityCandidateDao;
	}

	@Override
	public DataResult<List<AbilityCandidate>> getAll() {
		return new SuccessDataResult<List<AbilityCandidate>>(this.abilityCandidateDao.findAll(),"Tüm yetenekler listelendi");
	}

	@Override
	public Result add(AbilityCandidate abilityCandidate) {
	this.abilityCandidateDao.save(abilityCandidate);
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<AbilityCandidate>>(this.abilityCandidateDao.getByCandidate_Id(candidateId),"Adayın yetenekleri getirildi");
	}
	
	


	
}
