package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.AbilityCandidate;

public interface AbilityCandidateService {

	DataResult<List<AbilityCandidate>> getAll();
	
	DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId);
	
	Result add(AbilityCandidate abilityCandidate);
	
}
