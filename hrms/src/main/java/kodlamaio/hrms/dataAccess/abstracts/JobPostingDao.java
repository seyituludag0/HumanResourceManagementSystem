package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByIsActiveTrue();

	List<JobPosting> getByIsActiveTrueOrderByPostedDate();

	List<JobPosting> getByIsActiveTrueAndEmployer_companyName(String companyName);

	List<JobPosting> getAllByEmployerId(int employerId);
	
	JobPosting getById(int id);

	List<JobPosting> getAllByCity_Name(String name);

	List<JobPosting> getAllByCity_Id(int id);

//    -----------------------------------------------------------------------------------

	@Query("From JobPosting where is_open_employer = true") // iş veren tarafından eklenilen sadece
	List<JobPosting> getAllOpenJobPostingList();

	
	@Query("From JobPosting where is_open_employer = true Order By posted_date Asc") // iş veren tarafından verilen ilanın																// tarihsel sıraya göre gelmesi
	List<JobPosting> findAllByOrderByPostedDateAsc();
	
	
	@Query("From JobPosting where is_open_employer = true Order By posted_date Desc") // iş veren tarafından verilen ilanın																// tarihsel sıraya göre gelmesi
	List<JobPosting> findAllByOrderByPostedDateDesc();

	
	@Query("From JobPosting where is_open_employer = true and employer_id =:id") // iş ilanının employer iye göre gelmesi
	List<JobPosting> getAllOpenJobPostingByEmployer(int id);
	
	
	
	@Query("From JobPosting where is_active=true AND is_open_employer=true Order By posted_date DESC") // iş arayanın göreceği																	// 1.sayfa
	List<JobPosting> getAllByIsActiveByEmployer();

	
	@Query("From JobPosting where is_active=false AND is_open_employer=true Order By posted_date DESC") // active edilmemiş
	List<JobPosting> getAllByIsActiveByEmployer_False();

	

	@Query("From JobPosting where is_active=false And is_open_employer=true Order By posted_date DESC")//active edilmemiş ADMİN GÖRÜCEK
	List <JobPosting> getAllByIsActiveByEmployee_False();
	
}











