package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

public interface FavoriteJobPostingDao extends JpaRepository<FavoriteJobPosting, Integer>{

	FavoriteJobPosting getById(int id);
	
	List<FavoriteJobPosting> getByCandidate_Id(int jobcandidateId);
	
	List<FavoriteJobPosting> getByJobPosting_Id(int jobPostingId);
	
}
