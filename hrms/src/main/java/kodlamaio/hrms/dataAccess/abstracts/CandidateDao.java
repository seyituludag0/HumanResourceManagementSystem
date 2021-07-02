package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SocialMedia;


@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	Optional<Candidate> findByEmail(String email);
	Optional<Candidate> findByIdentityNumber(String identityNumber);
	
	Candidate findById(int id);
	
	List<Candidate> findByIdentityNumberContaining(String identityNumber);
	
	
}

