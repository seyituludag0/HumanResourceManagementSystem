package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

public interface FavoriteJobPostingService {

	 DataResult<List<FavoriteJobPosting>> getAll();
	 DataResult<FavoriteJobPosting> getById(int id);
	 DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId);
	 Result add(int candidateId, int jobPostingId);
	 Result delete(int candidateId, int jobPostingId);
	 DataResult<List<FavoriteJobPosting>> getByCandidateId(int candidateId);
	 DataResult<List<FavoriteJobPosting>> getByJobPostingId(int jobPostingId);
	
}

//int candidateId, int jobAdId