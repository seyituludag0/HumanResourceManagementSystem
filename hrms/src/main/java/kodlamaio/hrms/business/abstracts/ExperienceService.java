package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.dtos.experienceDto.CandidateExperienceDto;

public interface ExperienceService {

	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getByCandidate_IdOrderByLeaveDateDesc(int candidateId);
	DataResult<List<Experience>> getByCandidateId(int candidateId);
	Result add(CandidateExperienceDto candidateExperienceDto);
	Result update(CandidateExperienceDto candidateExperienceDto);	
}
