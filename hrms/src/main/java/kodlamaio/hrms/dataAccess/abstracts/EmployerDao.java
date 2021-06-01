package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
//import kodlamaio.hrms.entities.concretes.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    List<Employer> findByEmail(String email);
    List<Employer> findByEmailContaining(String email);
}
