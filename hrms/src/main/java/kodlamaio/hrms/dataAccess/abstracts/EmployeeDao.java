package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employee;
//import kodlamaio.hrms.entities.concretes.User;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

//	List<User> findByEmailContaining(String email);
	List<Employee> findByIdentityNumberContaining(String identityNumber);
	
	Employee getById(int id);
	
}
