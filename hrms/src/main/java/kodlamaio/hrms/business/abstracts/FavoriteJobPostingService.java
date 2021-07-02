package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

public interface FavoriteJobPostingService {

	 DataResult<List<FavoriteJobPosting>> getAll();
	 DataResult<FavoriteJobPosting> getById(int id);
	 Result add(FavoriteJobPosting favoriteJobPosting);
	 Result update(FavoriteJobPosting favoriteJobPosting);
	 Result delete(int id);
	 DataResult<List<FavoriteJobPosting>> getByCandidateId(int candidateId);
	 DataResult<List<FavoriteJobPosting>> getByJobPostingId(int jobPostingId);
	
}
