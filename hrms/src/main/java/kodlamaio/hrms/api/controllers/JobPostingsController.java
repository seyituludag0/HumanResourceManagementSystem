package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/jobPosting")
@CrossOrigin
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosting>> getAll(){
        return this.jobPostingService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPostingAddDto jobPostingAddDto) {
        return this.jobPostingService.add(jobPostingAddDto);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid JobPosting jobPosting) {
        return this.jobPostingService.update(jobPosting);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") int id){
        return this.jobPostingService.delete(id);
    }

    @GetMapping("/getByisActiveTrue")
    public DataResult<List<JobPostingDto>> getByIsActiveTrue(){
        return this.jobPostingService.getByIsActiveTrue();
    }

    @GetMapping("getByIsActiveTrueOrderByPostedDate")
    public DataResult<List<JobPostingDto>> getByIsActiveTrueOrderByPostedDate(){
        return this.jobPostingService.getByIsActiveTrueOrderByPostedDate();
    }
    
    @GetMapping("getAllJobPostingByEmployer")
    public DataResult<List<JobPosting>> getAllJobPostingByEmployer(@RequestParam int id){
        return this.jobPostingService.getAllJobPostingByEmployer(id);
    }
    
    @GetMapping("getByisActiveTrueAndEmployer_companyName")
    public DataResult<List<JobPostingDto>> getByIsActiveTrueAndEmployer_companyName(String companyName){
        return this.jobPostingService.getByIsActiveTrueAndEmployer_companyName(companyName);
    }
    
    @PostMapping("/changeIsActiveByEmployer")
	public Result changeIsActiveByEmployer(@RequestParam int id) {
		return this.jobPostingService.changeIsActiveByEmployer(id);
	}
    
    @PostMapping("/setActivetoPassive")
	public Result setActivetoPassive(@RequestParam int id) {
		return this.jobPostingService.setActivetoPassive(id);
	}
    
    @PostMapping("/changeActiveByEmployee")
	public Result setPassivetoActive(@RequestParam int id) {
		return this.jobPostingService.changeActiveByEmployee(id);
	}

    @GetMapping("/getById")
    public DataResult<JobPosting> getById(@RequestParam int id){
    	return this.jobPostingService.getById(id);
    }


    @GetMapping("getAllByCity_Name")
    public DataResult<List<JobPosting>> getAllByCityName(@RequestParam String name){
        return this.jobPostingService.getAllByCity_Name(name);
    }

    @GetMapping("getAllByCityId")
    public DataResult<List<JobPosting>> getAllByCityId(@RequestParam int cityId){
        return this.jobPostingService.getAllByCity_Id(cityId);
    }
    
////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("getAllOpenJobPostingList")
    public DataResult<List<JobPosting>> getAllOpenJobPostingList(){
    	return this.jobPostingService.getAllOpenJobPostingList();
    }
    
    @GetMapping("findAllByOrderByPostedDateAsc")
    public DataResult<List<JobPosting>> findAllByOrderByPostedDateAsc(@RequestParam int pageNo, @RequestParam int size) {
    	return this.jobPostingService.findAllByOrderByPostedDateAsc(pageNo, size);
    }
    
    @GetMapping("findAllByOrderByPostedDateDesc")
    public DataResult<List<JobPosting>> findAllByOrderByPostedDateDesc(@RequestParam int pageNo, @RequestParam int size) {
    	return this.jobPostingService.findAllByOrderByPostedDateDesc(pageNo, size);
    }
    
    
    @GetMapping("getAllOpenJobPostingByEmployer")
    public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(@RequestParam int id){
    	return this.jobPostingService.getAllOpenJobPostingByEmployer(id);
    }
    
    @GetMapping("getAllByIsActiveByEmployee")
    public DataResult<List<JobPosting>> getAllByIsActiveByEmployee(){
    	return this.jobPostingService.getAllByIsActiveByEmployee();
    }
    
    
    @GetMapping("getAllOpenJobPostingsAndIsActiveFalse")
    public DataResult<List<JobPosting>> getAllByIsActiveByEmployee_False(){
    	return this.jobPostingService.getAllByIsActiveByEmployee_False();
    }
    
    @GetMapping("getByWorkTypeId")
    public DataResult<List<JobPosting>> getByWorkTypeId(@RequestParam int workId){
    	return this.jobPostingService.getByWorkTypeId(workId);
    }
    
    @GetMapping("getAllPagination")
    public DataResult<List<JobPosting>> getAllPagination(@RequestParam int pageNo){
    	return this.jobPostingService.getAllPagination(pageNo);
    }
    
    @GetMapping("getByCityIdAndWorkTypeId")
    public DataResult<List<JobPosting>> getByCityIdAndWorkTypeId(@RequestParam int cityId, @RequestParam int workTypeId){
    	return this.jobPostingService.getByCityIdAndWorkTypeId(cityId, workTypeId);
    }
    
    @GetMapping("countByJobTitleId")
	public long countByJobTitle_Id(@RequestParam int jobTitleId) {
		return this.jobPostingService.countByJobTitleId(jobTitleId);
	}
	@GetMapping("countGetAll")
	public long countGetAll() {
		return this.jobPostingService.countGetAll();
	}
    
    
    
    
    
}
