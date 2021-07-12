package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.AbilityCandidate;

public interface AbilityCandidateDao extends JpaRepository<AbilityCandidate, Integer>{

	List<AbilityCandidate> getByCandidate_Id(int candidateId);
	AbilityCandidate findById(int id);
}
