package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationEmployer;

public interface VerificationEmployerDao extends JpaRepository<VerificationEmployer, Integer>{

}
