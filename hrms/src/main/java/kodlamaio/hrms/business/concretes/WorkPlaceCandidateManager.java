package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkPlaceCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceCandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.hrms.entities.concretes.WorkPlaceCandidate;
import kodlamaio.hrms.entities.concretes.dtos.workPlaceCandidateDto.WorkPlaceCandidateDto;

@Service
public class WorkPlaceCandidateManager implements WorkPlaceCandidateService {

	private WorkPlaceCandidateDao workplaceCandidateDao;
	private WorkPlaceDao workplaceDao;
	private CandidateDao candidateDao;
	private JobTitleDao jobTitleDao;

	public WorkPlaceCandidateManager(WorkPlaceCandidateDao workplaceCandidateDao, WorkPlaceDao workplaceDao,
			CandidateDao candidateDao, JobTitleDao jobTitleDao) {
		super();
		this.workplaceCandidateDao = workplaceCandidateDao;
		this.workplaceDao = workplaceDao;
		this.candidateDao = candidateDao;
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<WorkPlaceCandidate>> getAll() {
		return new SuccessDataResult<List<WorkPlaceCandidate>>(this.workplaceCandidateDao.findAll(),
				"Adayın çalışmış olduğu şirketler listelendi");
	}

	@Override
	public DataResult<List<WorkPlaceCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<WorkPlaceCandidate>>(this.workplaceCandidateDao.getByCandidateId(candidateId),
				"Adayın çalıştığı işyerleri listelendi");
	}

	@Override
	public Result add(WorkPlaceCandidateDto workPlaceCandidateDto) {
		WorkPlaceCandidate workPlaceCandidate = new WorkPlaceCandidate();

		workPlaceCandidate.setCandidate(this.candidateDao.findById(workPlaceCandidateDto.getCandidateId()));
		workPlaceCandidate.setWorkPlaceName(workPlaceCandidateDto.getWorkPlaceName());
		workPlaceCandidate.setJobTitle(workPlaceCandidateDto.getJobTitleName());
		workPlaceCandidate.setDateOfEntry(workPlaceCandidateDto.getDateOfEntry());
		workPlaceCandidate.setDateOfQuit(workPlaceCandidateDto.getDateOfQuit());
		
		this.workplaceCandidateDao.save(workPlaceCandidate);
		
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result update(WorkPlaceCandidateDto workPlaceCandidateDto) {
		WorkPlaceCandidate workPlaceCandidate = new WorkPlaceCandidate();
		workPlaceCandidate.setId(workPlaceCandidateDto.getId());
		
		workPlaceCandidate.setCandidate(this.candidateDao.findById(workPlaceCandidateDto.getCandidateId()));
		workPlaceCandidate.setWorkPlaceName(workPlaceCandidateDto.getWorkPlaceName());
		workPlaceCandidate.setJobTitle(workPlaceCandidateDto.getJobTitleName());
		workPlaceCandidate.setDateOfEntry(workPlaceCandidateDto.getDateOfEntry());
		workPlaceCandidate.setDateOfQuit(workPlaceCandidateDto.getDateOfQuit());
		
		this.workplaceCandidateDao.save(workPlaceCandidate);
		
		return new SuccessResult("Güncellendi");
	}
	@Override
	public Result delete(int id) {
		this.workplaceCandidateDao.deleteById(id);
		return new SuccessResult("Silindi");
	}
}
