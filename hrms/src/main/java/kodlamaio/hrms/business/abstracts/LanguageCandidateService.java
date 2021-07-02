package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageCandidate;
import kodlamaio.hrms.entities.concretes.dtos.languageCandidateDto.LanguageCandidateDto;

public interface LanguageCandidateService {

	DataResult<List<LanguageCandidate>> getAll();
	
	DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId);	
	
//	Result add(LanguageCandidate languageCandiate);
//	
//	Result update(LanguageCandidate languageCandiate);
	
Result add(LanguageCandidateDto languageCandidateDto);
	
	Result update(LanguageCandidateDto languageCandidateDto);
	
}
