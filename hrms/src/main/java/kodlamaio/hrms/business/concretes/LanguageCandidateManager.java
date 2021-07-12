package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageCandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.hrms.entities.concretes.LanguageCandidate;
import kodlamaio.hrms.entities.concretes.dtos.languageCandidateDto.LanguageCandidateDto;

@Service
public class LanguageCandidateManager implements LanguageCandidateService {

	private LanguageCandidateDao languageCandidateDao;
	private LanguageDao languageDao;
	private LanguageLevelDao languageLevelDao;
	private CandidateDao candidateDao;

	@Autowired
	public LanguageCandidateManager(LanguageCandidateDao languageCandidateDao, LanguageDao languageDao,
			CandidateDao candidateDao, LanguageLevelDao languageLevelDao) {
		super();
		this.languageCandidateDao = languageCandidateDao;
		this.languageDao = languageDao;
		this.languageLevelDao = languageLevelDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<LanguageCandidate>> getAll() {
		return new SuccessDataResult<List<LanguageCandidate>>(languageCandidateDao.findAll(),
				"Adayın dilleri getirildi");
	}

	@Override
	public Result add(LanguageCandidateDto languageCandidateDto) {

		LanguageCandidate languageCandidate = new LanguageCandidate();

		languageCandidate.setCandidate(this.candidateDao.findById(languageCandidateDto.getCandidateId()));
		languageCandidate.setLanguage(this.languageDao.findById(languageCandidateDto.getLanguageId()));
		languageCandidate.setLanguageLevel(this.languageLevelDao.findById(languageCandidateDto.getLanguageId()));
		
		this.languageCandidateDao.save(languageCandidate);
		
		return new SuccessResult("Adayın dil listesine eklendi");
	}

	@Override
	public Result update(LanguageCandidateDto languageCandidateDto) {

		LanguageCandidate languageCandidate = new LanguageCandidate();
		languageCandidate.setId(languageCandidateDto.getId());
		languageCandidate.setCandidate(this.candidateDao.findById(languageCandidateDto.getCandidateId()));
		languageCandidate.setLanguage(this.languageDao.findById(languageCandidateDto.getLanguageId()));
		languageCandidate.setLanguageLevel(this.languageLevelDao.findById(languageCandidateDto.getLanguageLevelId()));
		
		this.languageCandidateDao.save(languageCandidate);
		
		return new SuccessResult("Adayın dil listesine güncellendi");
	}

	@Override
	public DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<LanguageCandidate>>(this.languageCandidateDao.getByCandidate_Id(candidateId),
				"Adayın dil listesi getirildi");
	}

	@Override
	public Result delete(int id) {
		this.languageCandidateDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

}
