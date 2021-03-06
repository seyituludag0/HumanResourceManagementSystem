package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;
    private ModelMapper modelMapper;
    private CityDao cityDao;
    private EmployerDao employerDao;
    private JobTitleDao jobTitleDao;
    private WorkTypeDao workTypeDao;
    private WorkingTimeDao workingTimeDao;
    
    
    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao, ModelMapper modelMapper, CityDao cityDao,
    		EmployerDao employerDao, JobTitleDao jobTitleDao, WorkTypeDao workTypeDao,
    		WorkingTimeDao workingTimeDao)
    		 {
		super();
		this.jobPostingDao = jobPostingDao;
		this.modelMapper = modelMapper;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobTitleDao = jobTitleDao;
		this.workTypeDao = workTypeDao;
		this.workingTimeDao = workingTimeDao;
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
	public Result changeActiveByEmployee(int jobPostingId) {
		JobPosting jobAdvertToChangeIsOpen =this.jobPostingDao.getById(jobPostingId);      
		 jobAdvertToChangeIsOpen.setActive(!jobAdvertToChangeIsOpen.isActive()); 
		 this.jobPostingDao.save(jobAdvertToChangeIsOpen);  
		 return new SuccessResult("???? ilan??n??n i?? veren taraf??ndan taraf??ndan aktifli??i de??i??tirildi"); 
	}
	
	
	@Override
	public Result changeIsActiveByEmployer(int jobPostingId) {
		// ???? verenin aktiflik de??i??tirece??i
		JobPosting jobPostingToChangeIsActive =this.jobPostingDao.getById(jobPostingId);
		jobPostingToChangeIsActive.setOpenEmployer(!jobPostingToChangeIsActive.isOpenEmployer());
		this.jobPostingDao.save(jobPostingToChangeIsActive);
		return new SuccessResult("???? ilan?? i?? veren taraf??ndan taraf??ndan aktifli??i de??i??tirildi");
    
    
	}
	
	
	
	
    @Override
    public DataResult<List<JobPosting>> getAllByCity_Name(String name) {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByCity_Name(name),"??ehire g??re i?? ilanlar?? listelendi");
    }

    @Override
    public DataResult<List<JobPosting>> getAllByCity_Id(int id) {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByCity_Id(id),"??ehire g??re i?? ilanlar?? listelendi");
    }

	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		
		JobPosting jobPosting = new JobPosting();
		
		jobPosting.setCity(this.cityDao.findById(jobPostingAddDto.getCityId()));
		jobPosting.setEmployer(this.employerDao.findById(jobPostingAddDto.getEmployerId()));
		jobPosting.setWorkType(this.workTypeDao.getOne(jobPostingAddDto.getWorkTypeId()));
		jobPosting.setWorkingTimes(this.workingTimeDao.getOne(jobPostingAddDto.getWorkingTimeId()));
		jobPosting.setJobDetails(jobPostingAddDto.getJobDetails());
		jobPosting.setJobTitle(this.jobTitleDao.getOne(jobPostingAddDto.getJobTitleId()));
		jobPosting.setLastApplyDate(jobPostingAddDto.getLastApplyDate());
		jobPosting.setNumberOfOpenPositions(jobPostingAddDto.getNumberOfOpenPositions());
		jobPosting.setMinWage(jobPostingAddDto.getMinWage());
		jobPosting.setMaxWage(jobPostingAddDto.getMaxWage());

		jobPosting.setOpenEmployer(true);

		this.jobPostingDao.save(jobPosting);
		
		
		return new SuccessResult("???? ilan?? eklendi");
		
	}

//	/////////////////////////////////////////////////////////////////////////////////////////////
	
//	Pageable pageable = PageRequest.of(pageNo-1, 10);
	
	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPostingList() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPostingList());
	}
	
	
//	@Override
//	public DataResult<List<JobPosting>> getAllOpenJobPostingList(int pageNo) {
//		Pageable pageable = PageRequest.of(pageNo, 10);
//		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPostingList());
//	}
	
	

	@Override
	public DataResult<List<JobPosting>> findAllByOrderByPostedDateAsc(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1, size);
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByOrderByPostedDateAsc(pageable));
	}
	
	@Override
	public DataResult<List<JobPosting>> findAllByOrderByPostedDateDesc(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1, size);
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByOrderByPostedDateDesc(pageable));
	
	}

	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPostingByEmployer(id));
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveByEmployee() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveByEmployer());
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveByEmployee_False() {
		// A????k olan i?? ilanlar??n?? admin g??recek sadece kendi sisteminden onaylamak i??in
	return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveByEmployee_False());
	}

	
	@Override
	public DataResult<List<JobPosting>> getAllJobPostingByEmployer(int id) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByEmployerId(id), "???? ilanlar?? employer id'sine g??re listelendi");
	}

//	@Override
//	public DataResult<List<JobPosting>> getByCityId(int cityId) {
//		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getbyc)
//	}
//
	@Override
	public DataResult<List<JobPosting>> getByWorkTypeId(int workId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByWorkType_Id(workId),"??al????ma tipine g??re i?? ilanlar?? listelendi");
	}


	@Override
    public DataResult<List<JobPosting>> getAllPagination(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1, 10);

        return  new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(pageable).getContent(),"Ba??ar??l??");
    }

	@Override
	public DataResult<List<JobPosting>> getByCityIdAndWorkTypeId(int cityId, int workTypeId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByCity_IdAndWorkType_Id(cityId, workTypeId));
	}

	@Override
	public long countByJobTitleId(int jobTitleId) {
		return this.jobPostingDao.countByJobTitle_Id(jobTitleId);
	}

	@Override
	public long countGetAll() {
		return this.jobPostingDao.count();
}

	@Override
	public DataResult<List<JobPosting>> getByJobTitleAndCityNameAndWorkTypeId(String jobTitle, String cityName, int workTypeId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByJobTitle_TitleAndCity_NameAndWorkType_Id(jobTitle,cityName, workTypeId), "??lanlar ??ehire ve ??al????ma t??r??ne g??re getirildi");
	}

	

	
}


