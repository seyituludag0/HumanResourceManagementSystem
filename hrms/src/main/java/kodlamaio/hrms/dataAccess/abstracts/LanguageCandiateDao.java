package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LanguageCandiate;

public interface LanguageCandiateDao extends JpaRepository<LanguageCandiate, Integer>{

}
