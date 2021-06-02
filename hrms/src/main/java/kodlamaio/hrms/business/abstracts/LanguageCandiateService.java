package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageCandiate;

public interface LanguageCandiateService {

	DataResult<List<LanguageCandiate>> getAll();
	Result add(LanguageCandiate languageCandiate);
}
