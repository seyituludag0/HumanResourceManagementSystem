package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

@Service
public class FavoriteJobPostingManager implements FavoriteJobPostingService{

	private FavoriteJobPostingDao favoriteJobPostingDao;
	private CandidateDao candidateDao;
	private JobPostingDao jobPostingDao;

	@Autowired
	public FavoriteJobPostingManager(FavoriteJobPostingDao favoriteJobPostingDao, CandidateDao candidateDao, JobPostingDao jobPostingDao) {
		super();
		this.favoriteJobPostingDao = favoriteJobPostingDao;
		this.candidateDao = candidateDao;
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return new SuccessDataResult<List<FavoriteJobPosting>>(this.favoriteJobPostingDao.findAll());
	}

	
	@Override
	public Result add(int candidateId, int jobPostingId) {
		
		if(existsByCandidateIdAndJobPostingId(candidateId, jobPostingId)) {
			this.delete(candidateId, jobPostingId);
			return new ErrorResult("İlan favorilerinizden kaldırıldı");
		}
		
		FavoriteJobPosting favoriteJobPosting = new FavoriteJobPosting();
		
		favoriteJobPosting.setCandidate(this.candidateDao.findById(candidateId));
		favoriteJobPosting.setJobPosting(this.jobPostingDao.getById(jobPostingId));
		
		this.favoriteJobPostingDao.save(favoriteJobPosting);
		
		return new SuccessResult("Favorilere eklendi");
	}

	@Override
	public Result delete(int candidateId, int jobPostingId) {
		this.favoriteJobPostingDao.deleteById(this.favoriteJobPostingDao.getByCandidateIdAndJobPostingId(candidateId, jobPostingId).getId());
		return new SuccessResult();
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<FavoriteJobPosting>>(this.favoriteJobPostingDao.getByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getByJobPostingId(int jobPostingId) {
		return new SuccessDataResult<List<FavoriteJobPosting>>(this.favoriteJobPostingDao.getByJobPosting_Id(jobPostingId));
	}

	@Override
	public DataResult<FavoriteJobPosting> getById(int id) {
		return new SuccessDataResult<FavoriteJobPosting>(this.favoriteJobPostingDao.getById(id));
	}

	@Override
	public DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId) {
		return new SuccessDataResult<FavoriteJobPosting>(this.favoriteJobPostingDao.getByCandidateIdAndJobPostingId(candidateId, jobPostingId));
	}
	
	private boolean existsByCandidateIdAndJobPostingId(int candidateId, int jobPostingId) {
		var favoriteJobPosting = this.favoriteJobPostingDao.existsByCandidate_IdAndJobPosting_Id(candidateId, jobPostingId);
		if(favoriteJobPosting) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
