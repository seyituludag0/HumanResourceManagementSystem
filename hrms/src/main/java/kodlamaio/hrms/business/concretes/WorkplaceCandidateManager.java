package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkplaceCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkplaceCandidateDao;
import kodlamaio.hrms.entities.concretes.WorkplaceCandidate;

@Service
public class WorkplaceCandidateManager implements WorkplaceCandidateService{

	private WorkplaceCandidateDao workplaceCandidateDao;
	
	public WorkplaceCandidateManager(WorkplaceCandidateDao workplaceCandidateDao) {
		super();
		this.workplaceCandidateDao = workplaceCandidateDao;
	}

	@Override
	public DataResult<List<WorkplaceCandidate>> getAll() {
		return new SuccessDataResult<List<WorkplaceCandidate>>(this.workplaceCandidateDao.findAll(),"Adayın çalışmış olduğu şirketler listelendi");
	}

	@Override
	public Result add(WorkplaceCandidate workplaceCandidate) {
		this.workplaceCandidateDao.save(workplaceCandidate);
		return new SuccessResult("Adayın çalışmış olduğu şirketler listesine eklendi");
	}
	
}
