package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;
    private ModelMapper modelMapper;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao, ModelMapper modelMapper) {
        this.jobPostingDao = jobPostingDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        List<JobPosting> jobPostings = this.jobPostingDao.findAll();
        if(jobPostings.isEmpty()){
            return new ErrorDataResult<>(Message.nullJobPosting);
        }
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),Message.getAllJobPosting);
    }

    @Override
    public Result add(JobPosting jobPosting) {
        if (!checkIfNullField(jobPosting)) {
            return new ErrorResult(Message.checkIfNullField);
        }
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult(Message.addJobPosting);
    }

    @Override
    public Result update(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult(Message.updateJobPosting);
    }



    @Override
    public Result delete(int id) {
        this.jobPostingDao.deleteById(id);
        return new SuccessResult(Message.deleteJobPosting);
    }


    @Override
	public DataResult<List<JobPostingDto>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobPostingDto>>
                (this.dtoGenerator(this.jobPostingDao.getByIsActiveTrue()),Message.getByisActiveTrue);
	}

	@Override
	public DataResult<List<JobPostingDto>> getByIsActiveTrueOrderByPostedDate() {
        return new SuccessDataResult<List<JobPostingDto>>
                (this.dtoGenerator(this.jobPostingDao.getByIsActiveTrueOrderByPostedDate()),Message.getByIsActiveTrueOrderByPostedDate);
	}

	@Override
	public DataResult<List<JobPostingDto>> getByIsActiveTrueAndEmployer_companyName(String companyName) {
        return new SuccessDataResult<List<JobPostingDto>>
                (this.dtoGenerator(this.jobPostingDao.getByIsActiveTrueAndEmployer_companyName(companyName)),Message.getByIsActiveTrueAndEmployer_companyName);
	}

    


    private List<JobPostingDto> dtoGenerator(List<JobPosting> jobPostings){
        List<JobPostingDto> jobPostingDtos = new ArrayList<JobPostingDto>();
        jobPostings.forEach(item -> {
            JobPostingDto dto=modelMapper.map(item, JobPostingDto.class);
            dto.setCompanyName(item.getEmployer().getCompanyName());
            jobPostingDtos.add(dto);
        });
        return jobPostingDtos;

    }

    private boolean checkIfNullField(JobPosting jobPosting){
        if (jobPosting.getJobTitle() != null && jobPosting.getJobDetails() != null && jobPosting.getCity() != null
        && jobPosting.getNumberOfOpenPositions() != 0){
            return true;
        }
        return false;
    }

	@Override
public DataResult<JobPosting> getById(int id) {
		JobPosting jobPosting = this.jobPostingDao.getById(id);
		if(jobPosting==null) {
			return new ErrorDataResult<JobPosting>(Message.notFoundJobPosting);
		}
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getOne(id),Message.getJobPosting);
	}

	@Override
	public Result setActivetoPassive(int id) {
		JobPosting jobPosting = getById(id).getData();
		if(jobPosting.isActive()) {
		jobPosting.setActive(false);
		update(jobPosting);
		return new SuccessResult(Message.jobPostingActived);
		}else {

		return new ErrorResult(Message.jobPostingIsAlreadyPassive);
		}
	}

    @Override
    public DataResult<List<JobPosting>> getAllByCity_Name(String name) {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByCity_Name(name),"Şehire göre iş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobPosting>> getAllByCity_Id(int id) {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByCity_Id(id),"Şehire göre iş ilanları listelendi");
    }

	

	


}


