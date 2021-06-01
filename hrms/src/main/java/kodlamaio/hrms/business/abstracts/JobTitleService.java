package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> get(int id);
	Result add(JobTitle jobTitle);
	Result update(JobTitle jobTitle);
	Result delete(int id);
}
