package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingConfirmDao;
import kodlamaio.hrms.entities.concretes.JobPostingConfirm;

@Service
public class JobPostingConfirmManager implements JobPostingConfirmService{

	private JobPostingConfirmDao jobPostingConfirmDao;

	@Autowired
	public JobPostingConfirmManager(JobPostingConfirmDao jobPostingConfirmDao) {
		super();
		this.jobPostingConfirmDao = jobPostingConfirmDao;
	}

	@Override
	public DataResult<List<JobPostingConfirm>> getAll() {
		return new SuccessDataResult<List<JobPostingConfirm>>(this.jobPostingConfirmDao.findAll(), "Listelendi");
	}

	@Override
	public Result confirm(JobPostingConfirm jobPostingConfirm) {
		this.jobPostingConfirmDao.save(jobPostingConfirm);
		return new SuccessResult("Confirmed");
	}

	
}
