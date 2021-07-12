package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkPlaceCandidate;

public interface WorkPlaceCandidateDao extends JpaRepository<WorkPlaceCandidate, Integer>{

	List<WorkPlaceCandidate> getByCandidateId(int candidateId);
	
	WorkPlaceCandidate findById(int id);
	
}
