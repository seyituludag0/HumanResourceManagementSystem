package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkplaceCandidate;

public interface WorkplaceCandidateDao extends JpaRepository<WorkplaceCandidate, Integer>{

}
