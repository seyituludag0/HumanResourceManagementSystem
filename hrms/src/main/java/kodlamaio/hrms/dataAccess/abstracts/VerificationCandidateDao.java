package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.VerificationCandidate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VerificationCandidateDao extends JpaRepository<VerificationCandidate, Integer>{

}
