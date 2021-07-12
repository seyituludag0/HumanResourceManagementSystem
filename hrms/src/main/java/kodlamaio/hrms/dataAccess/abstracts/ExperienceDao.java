package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

	List<Experience> getByCandidate_IdOrderByLeaveDateDesc(int candidateId);
	List<Experience> getByCandidate_Id(int candidateId);
	
	Experience findById(int id);
	
}
