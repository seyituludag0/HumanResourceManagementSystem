package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobPostingDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

@Service
public class FavoriteJobPostingManager implements FavoriteJobPostingService{

	private FavoriteJobPostingDao favoriteJobPostingDao;

	@Autowired
	public FavoriteJobPostingManager(FavoriteJobPostingDao favoriteJobPostingDao) {
		super();
		this.favoriteJobPostingDao = favoriteJobPostingDao;
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return new SuccessDataResult<List<FavoriteJobPosting>>(this.favoriteJobPostingDao.findAll());
	}

	@Override
	public Result add(FavoriteJobPosting favoriteJobPosting) {
		this.favoriteJobPostingDao.save(favoriteJobPosting);
		return new SuccessResult("Favorilerew eklendi");
	}

	@Override
	public Result update(FavoriteJobPosting favoriteJobPosting) {
		this.favoriteJobPostingDao.save(favoriteJobPosting);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		this.favoriteJobPostingDao.deleteById(id);
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
	
	
	
}
