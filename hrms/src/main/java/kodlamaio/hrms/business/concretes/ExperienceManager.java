package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.dtos.experienceDto.CandidateExperienceDto;

@Service
public class ExperienceManager implements ExperienceService{

	private ExperienceDao experienceDao;
	private CandidateDao candidateDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao, CandidateDao candidateDao) {
		super();
		this.experienceDao = experienceDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
	return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"Tecrübeler listelendi");
	}

	@Override
	public DataResult<List<Experience>> getByCandidate_IdOrderByLeaveDateDesc(int candidateId){
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByCandidate_IdOrderByLeaveDateDesc(candidateId));
	}


	@Override
	public DataResult<List<Experience>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByCandidate_Id(candidateId),"Adayın yetenekleri getirildi");
	}

	@Override
	public Result add(CandidateExperienceDto candidateExperienceDto) {
		
		Experience experience = new Experience();
		
		experience.setCandidate(this.candidateDao.findById(candidateExperienceDto.getCandidateId()));
		experience.setCompanyName(candidateExperienceDto.getCompanyName());
		experience.setPosition(candidateExperienceDto.getPosition());
		experience.setStartDate(candidateExperienceDto.getStartDate());
		experience.setLeaveDate(candidateExperienceDto.getLeaveDate());
		
		this.experienceDao.save(experience);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result update(CandidateExperienceDto candidateExperienceDto) {
Experience experience = new Experience();
		experience.setId(candidateExperienceDto.getId());
		experience.setCandidate(this.candidateDao.findById(candidateExperienceDto.getCandidateId()));
		experience.setCompanyName(candidateExperienceDto.getCompanyName());
		experience.setPosition(candidateExperienceDto.getPosition());
		experience.setStartDate(candidateExperienceDto.getStartDate());
		experience.setLeaveDate(candidateExperienceDto.getLeaveDate());
		
		this.experienceDao.save(experience);
		return new SuccessResult("Güncellendi");
	}

	
	
}
