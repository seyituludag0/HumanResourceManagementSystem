package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;

import java.util.List;

public interface JobPostingService {
    DataResult<List<JobPosting>> getAll();
    Result update(JobPosting jobPosting);
    Result add(JobPosting jobPosting);
    Result delete(int id);

    Result setActivetoPassive(int id);

    DataResult<List<JobPostingDto>> getByIsActiveTrue();
    DataResult<List<JobPostingDto>> getByIsActiveTrueOrderByPostedDate();
    DataResult<List<JobPostingDto>> getByIsActiveTrueAndEmployer_companyName(String companyName);

    DataResult<JobPosting> getById(int id);
}
