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
import kodlamaio.hrms.dataAccess.abstracts.AbilityDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.AbilityCandidate;
import kodlamaio.hrms.entities.concretes.dtos.abilityCandidateDto.AbilityCandidateDto;

@Service
public class AbilityCandidateManager implements AbilityCandidateService {

	private AbilityCandidateDao abilityCandidateDao;
	private CandidateDao candidateDao;
	private AbilityDao abiltyDao;

	@Autowired
	public AbilityCandidateManager(AbilityCandidateDao abilityCandidateDao, CandidateDao candidateDao,
			AbilityDao abiltyDao) {
		super();
		this.abilityCandidateDao = abilityCandidateDao;
		this.candidateDao = candidateDao;
		this.abiltyDao = abiltyDao;
	}

	@Override
	public DataResult<List<AbilityCandidate>> getAll() {
		return new SuccessDataResult<List<AbilityCandidate>>(this.abilityCandidateDao.findAll(),
				"Tüm yetenekler listelendi");
	}

	

	@Override
	public DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<AbilityCandidate>>(this.abilityCandidateDao.getByCandidate_Id(candidateId),
				"Adayın yetenekleri getirildi");
	}

	@Override
	public Result add(AbilityCandidateDto abilityCandidateDto) {
		AbilityCandidate abilityCandidate = new AbilityCandidate();
		abilityCandidate.setAbility(this.abiltyDao.findById(abilityCandidateDto.getAbilityId()));
		abilityCandidate.setCandidate(this.candidateDao.findById(abilityCandidateDto.getCandidateId()));
		
		this.abilityCandidateDao.save(abilityCandidate);
		
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result update(AbilityCandidateDto abilityCandidateDto) {
		AbilityCandidate abilityCandidate = new AbilityCandidate();
		abilityCandidate.setId(abilityCandidateDto.getId());
		abilityCandidate.setAbility(this.abiltyDao.findById(abilityCandidateDto.getAbilityId()));
		abilityCandidate.setCandidate(this.candidateDao.findById(abilityCandidateDto.getCandidateId()));
		
		this.abilityCandidateDao.save(abilityCandidate);
		
		return new SuccessResult("Güncellendi");
	}


}
