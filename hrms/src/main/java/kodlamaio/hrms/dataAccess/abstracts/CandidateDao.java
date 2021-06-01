package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import kodlamaio.hrms.entities.concretes.Candidate;


@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
//	List<Candidate> findByIdentityNumber(String identityNumber);
//	List<Candidate> findByEmail(String email);
	Optional<Candidate> findByEmail(String email);
	Optional<Candidate> findByIdentityNumber(String identityNumber);
	
	List<Candidate> findByIdentityNumberContaining(String identityNumber);
}
