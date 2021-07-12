package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingFilterDto;

import java.util.List;

public interface JobPostingService {
	
	DataResult<List<JobPosting>> getByFilter(JobPostingFilterDto filter);
	
	
    DataResult<List<JobPosting>> getAll();
    Result update(JobPosting jobPosting);
    Result add(JobPostingAddDto jobPostingAddDto);
    Result delete(int id);

    Result setActivetoPassive(int id);
    
    Result changeActiveByEmployee(int id);

    DataResult<List<JobPostingDto>> getByIsActiveTrue();
    DataResult<List<JobPostingDto>> getByIsActiveTrueOrderByPostedDate();
    
    DataResult<List<JobPosting>> getAllByEmployerId(int employerId);

    DataResult<JobPosting> getById(int id);
    
    Result changeIsActiveByEmployer(int jobPostingId);
    
    DataResult<List<JobPosting>> getAllJobPostingByEmployer(int id);
    
    DataResult<List<JobPosting>> getAllByCity_Name(String name);

    DataResult<List<JobPosting>> getAllByCity_Id(int id);
    

    DataResult<List<JobPosting>> getAllOpenJobPostingList();
    
//    DataResult<List<JobPosting>> getAllOpenJobPostingList(int pageNo);
    
    DataResult<List<JobPosting>> findAllByOrderByPostedDateDesc(int pageNo, int size);
    
    DataResult<List<JobPosting>> findAllByOrderByPostedDateAsc(int pageNo, int size);
    
    DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id);
    
    DataResult<List<JobPosting>> getAllByIsActiveByEmployee();
    
    DataResult<List<JobPosting>> getAllByIsActiveByEmployee_False();
    
//    DataResult<List<JobPosting>> getAllByIsActiveAndIsOpen_False();


//    DataResult<List<JobPosting>> getAllByIsActiveByEmployee_False();

//    DataResult<List<JobPosting>> getAllOpenAndFalseJobPostingList();
    
//    DataResult<List<JobPosting>>getByCityId(int cityId);
//    
    DataResult<List<JobPosting>>getByWorkTypeId(int workId);
    
    DataResult<List<JobPosting>> getByCityIdAndWorkTypeId(int cityId, int workTypeId);
  
    DataResult<List<JobPosting>> getAllPagination(int pageNo);
    
    long countByJobTitleId(int jobTitleId);

	long countGetAll(); 
	
	DataResult<List<JobPosting>> getByJobTitleAndCityNameAndWorkTypeId(String jobTitle, String cityName, int workTypeId);

}

