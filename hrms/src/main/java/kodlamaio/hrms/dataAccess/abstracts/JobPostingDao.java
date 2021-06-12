package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
    List<JobPosting> getByIsActiveTrue();
    List<JobPosting> getByIsActiveTrueOrderByPostedDate();
    List<JobPosting> getByIsActiveTrueAndEmployer_companyName(String companyName);
    
    JobPosting getById(int id);
   

    List<JobPosting> getAllByCity_Name(String name);

    List<JobPosting> getAllByCity_Id(int id);

}
