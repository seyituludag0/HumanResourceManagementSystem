package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingFilterDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	
	List<JobPosting> getByIsActiveTrue();

	List<JobPosting> getByIsActiveTrueOrderByPostedDate();


	List<JobPosting> getAllByEmployerId(int employerId);
	
	JobPosting getById(int id);

	List<JobPosting> getAllByCity_Name(String name);

	List<JobPosting> getAllByCity_Id(int id);


	List<JobPosting> getByWorkType_Id(int workId);
	
	List<JobPosting> getByCity_IdAndWorkType_Id(int cityId, int workTypeId);
	
	
	List<JobPosting> getByJobTitle_TitleAndCity_NameAndWorkType_Id(String title, String cityName, int workTypeId);
	
//    -----------------------------------------------------------------------------------

	@Query("From JobPosting where is_open_employer = true") // iş veren tarafından eklenilen sadece
	List<JobPosting> getAllOpenJobPostingList();

	
	@Query("From JobPosting where is_open_employer = true Order By posted_date Asc") // iş veren tarafından verilen ilanın																// tarihsel sıraya göre gelmesi
	List<JobPosting> findAllByOrderByPostedDateAsc(Pageable pageable); //Önceden Eklenen İlanlar
	
	
	@Query("From JobPosting where is_open_employer = true Order By posted_date Desc") // iş veren tarafından verilen ilanın																// tarihsel sıraya göre gelmesi
//	List<JobPosting> findAllByOrderByPostedDateDesc(); //Yeni Eklenen İlanlar
	List<JobPosting> findAllByOrderByPostedDateDesc(Pageable pageable);

	
	@Query("From JobPosting where is_open_employer = true and employer_id =:id") // iş ilanının employer iye göre gelmesi
	List<JobPosting> getAllOpenJobPostingByEmployer(int id);
	
	
	
	@Query("From JobPosting where is_active=true AND is_open_employer=true Order By posted_date DESC") // iş arayanın göreceği																	// 1.sayfa
	List<JobPosting> getAllByIsActiveByEmployer();

	
	@Query("From JobPosting where is_active=false AND is_open_employer=true Order By posted_date DESC") // active edilmemiş
	List<JobPosting> getAllByIsActiveByEmployer_False();

	

	@Query("From JobPosting where is_active=false And is_open_employer=true Order By posted_date DESC")//active edilmemiş ADMİN GÖRÜCEK
	List <JobPosting> getAllByIsActiveByEmployee_False();
//  -----------------------------------------------------------------------------------

	int countByJobTitle_Id(int jobTitleId);
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	@Query("Select j from kodlamaio.hrms.entities.concretes.JobPosting j where "
//	        +"j.isActive=true and"
//	        +"((:#{#filter.searchText}) IS NULL OR j.jobDetails like %:#{#filter.searchText}% OR LOWER(j.jobDetails) like %:#{#filter.searchText}% OR UPPER(j.jobDetails) like %:#{#filter.searchText}%) " 
//			)
//	    public List<JobPosting> getByFilter(@Param("filter") JobPostingFilterDto jobPostingFilter);


	@Query("Select j from kodlamaio.hrms.entities.concretes.JobPosting j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
	        +" and ((:#{#filter.jobTitleId}) IS NULL OR j.jobTitle.id IN (:#{#filter.jobTitleId}))"
	        +" and ((:#{#filter.searchText}) IS NULL OR j.jobDetails like %:#{#filter.searchText}% OR LOWER(j.jobDetails) like %:#{#filter.searchText}% OR UPPER(j.jobDetails) like %:#{#filter.searchText}%) " 
	        +" and j.isActive=true"
			)
	    public List<JobPosting> getByFilter(@Param("filter") JobPostingFilterDto jobPostingFilter);






}