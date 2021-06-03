package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageCandidateDao;
import kodlamaio.hrms.entities.concretes.LanguageCandidate;

@Service
public class LanguageCandidateManager implements LanguageCandidateService{

	private LanguageCandidateDao languageCandidateDao;

	@Autowired
	public LanguageCandidateManager(LanguageCandidateDao languageCandidateDao) {
		super();
		this.languageCandidateDao = languageCandidateDao;
	}

	@Override
	public DataResult<List<LanguageCandidate>> getAll() {
		return new SuccessDataResult<List<LanguageCandidate>>(languageCandidateDao.findAll(),"Adayın dilleri getirildi");
	}

	@Override
	public Result add(LanguageCandidate languageCandidate) {
		this.languageCandidateDao.save(languageCandidate);
		return new SuccessResult("Adayın dil listesine eklendi");
	}

	@Override
	public DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<LanguageCandidate>>(this.languageCandidateDao.getByCandidate_Id(candidateId),"Adayın dil listesi getirildi");
	}

	
	
}
