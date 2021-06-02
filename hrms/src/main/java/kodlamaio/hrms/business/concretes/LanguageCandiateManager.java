package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageCandiateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageCandiateDao;
import kodlamaio.hrms.entities.concretes.LanguageCandiate;

@Service
public class LanguageCandiateManager implements LanguageCandiateService{

	private LanguageCandiateDao languageCandiateDao;

	@Autowired
	public LanguageCandiateManager(LanguageCandiateDao languageCandiateDao) {
		super();
		this.languageCandiateDao = languageCandiateDao;
	}

	@Override
	public DataResult<List<LanguageCandiate>> getAll() {
		return new SuccessDataResult<List<LanguageCandiate>>(languageCandiateDao.findAll(),"Adayın dilleri getirildi");
	}

	@Override
	public Result add(LanguageCandiate languageCandiate) {
		this.languageCandiateDao.save(languageCandiate);
		return new SuccessResult("Adayın dil listesine eklendi");
	}

	
	
}
