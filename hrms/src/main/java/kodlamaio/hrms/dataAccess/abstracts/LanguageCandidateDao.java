package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LanguageCandidate;

public interface LanguageCandidateDao extends JpaRepository<LanguageCandidate, Integer>{

	List<LanguageCandidate> getByCandidate_Id(int candidateId);
	LanguageCandidate findById(int id);
}
