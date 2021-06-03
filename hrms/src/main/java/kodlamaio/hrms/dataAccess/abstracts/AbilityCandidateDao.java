package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Ability;
import kodlamaio.hrms.entities.concretes.AbilityCandidate;

public interface AbilityCandidateDao extends JpaRepository<AbilityCandidate, Integer>{

}
