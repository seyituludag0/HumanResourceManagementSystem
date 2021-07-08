package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		List<JobTitle> jobTitles = this.jobTitleDao.findAll();
		return new DataResult<List<JobTitle>>(jobTitles, true, Message.getAllJobTitle);
	}

	@Override
	public DataResult<JobTitle> get(int id) {
		JobTitle jobTitle = this.jobTitleDao.getOne(id);
		return new DataResult<JobTitle>(jobTitle,true,Message.getJobTitle);
	}

	@Override
	public Result add(JobTitle jobTitle) {
		jobTitleDao.save(jobTitle);
		return new SuccessResult(Message.addJobTitle);
	}

	@Override
	public Result update(JobTitle jobTitle) {
		jobTitleDao.save(jobTitle);
		return new SuccessResult(Message.updateJobTitle);
	}

	@Override
	public Result delete(int id) {
		jobTitleDao.deleteById(id);
		return new SuccessResult(Message.deleteJobTitle);
	}

	@Override
	public long countGetAll() {
		return this.jobTitleDao.count();
	}

}
