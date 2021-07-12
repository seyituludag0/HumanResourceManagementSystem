package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPostingConfirm;

public interface JobPostingConfirmDao extends JpaRepository<JobPostingConfirm, Integer>{

	JobPostingConfirm getById(int id);
	
}
