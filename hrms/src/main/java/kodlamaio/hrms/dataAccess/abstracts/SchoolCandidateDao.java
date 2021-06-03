package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolCandidate;

public interface SchoolCandidateDao extends JpaRepository<SchoolCandidate, Integer>{
	List<SchoolCandidate> getByCandidateId(int candidateId);
}
