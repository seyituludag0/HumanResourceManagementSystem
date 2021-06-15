package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingConfirm;

public interface JobPostingConfirmService {
	
	DataResult<List<JobPostingConfirm>> getAll();
	Result confirm(JobPostingConfirm jobPostingConfirm);
	
}
