package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkplaceCandidate;

public interface WorkplaceCandidateService {

	DataResult<List<WorkplaceCandidate>> getAll();
	Result add(WorkplaceCandidate workplaceCandidate);
	
}
