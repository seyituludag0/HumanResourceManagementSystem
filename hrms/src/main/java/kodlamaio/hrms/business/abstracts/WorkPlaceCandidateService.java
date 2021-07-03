package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkPlaceCandidate;
import kodlamaio.hrms.entities.concretes.dtos.workPlaceCandidateDto.WorkPlaceCandidateDto;

public interface WorkPlaceCandidateService {

	DataResult<List<WorkPlaceCandidate>> getAll();
	
	DataResult<List<WorkPlaceCandidate>> getByCandidateId(int candidateId);
	
	Result add(WorkPlaceCandidateDto workPlaceCandidateDto);
	
	Result update(WorkPlaceCandidateDto workPlaceCandidateDto);
	Result delete(int id);
}
