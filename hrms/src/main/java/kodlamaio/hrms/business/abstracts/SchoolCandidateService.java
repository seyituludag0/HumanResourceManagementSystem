package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;
import kodlamaio.hrms.entities.concretes.dtos.candidateSchoolsDto.SchoolCandidateDto;

public interface SchoolCandidateService {

	DataResult<List<SchoolCandidate>> getAll();
	
	DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId);
	
	DataResult<List<SchoolCandidate>> getByCandidate_IdOrderByDateOfGraduationDesc(int candidateId);
	
//	Result add(SchoolCandidate schoolCandidate);

	Result add(SchoolCandidateDto schoolCandidateDto);
	
//	Result update(SchoolCandidate schoolCandidate);
	
	Result update(SchoolCandidateDto schoolCandidateDto);
}
