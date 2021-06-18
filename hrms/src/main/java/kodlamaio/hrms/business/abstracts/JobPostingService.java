package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;

import java.util.List;

public interface JobPostingService {
    DataResult<List<JobPosting>> getAll();
    Result update(JobPosting jobPosting);
    Result add(JobPostingAddDto jobPostingAddDto);
    Result delete(int id);

    Result setActivetoPassive(int id);
    
    Result changeActiveByEmployee(int id);

    DataResult<List<JobPostingDto>> getByIsActiveTrue();
    DataResult<List<JobPostingDto>> getByIsActiveTrueOrderByPostedDate();
    DataResult<List<JobPostingDto>> getByIsActiveTrueAndEmployer_companyName(String companyName);

    DataResult<JobPosting> getById(int id);
    
    Result changeIsActiveByEmployer(int jobPostingId);
    
    DataResult<List<JobPosting>> getAllJobPostingByEmployer(int id);
    
    DataResult<List<JobPosting>> getAllByCity_Name(String name);

    DataResult<List<JobPosting>> getAllByCity_Id(int id);
    

    DataResult<List<JobPosting>> getAllOpenJobPostingList();
    
    DataResult<List<JobPosting>> findAllByOrderByPostedDateDesc();
    
    DataResult<List<JobPosting>> findAllByOrderByPostedDateAsc();
    
    DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id);
    
    DataResult<List<JobPosting>> getAllByIsActiveByEmployee();
    
    DataResult<List<JobPosting>> getAllByIsActiveByEmployee_False();
    
//    DataResult<List<JobPosting>> getAllByIsActiveAndIsOpen_False();


//    DataResult<List<JobPosting>> getAllByIsActiveByEmployee_False();

//    DataResult<List<JobPosting>> getAllOpenAndFalseJobPostingList();
    

    
}

