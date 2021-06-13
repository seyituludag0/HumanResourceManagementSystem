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
@RequestMapping("api/jobposting")
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
    
    @GetMapping("getByisActiveTrueAndEmployer_companyName")
    public DataResult<List<JobPostingDto>> getByIsActiveTrueAndEmployer_companyName(String companyName){
        return this.jobPostingService.getByIsActiveTrueAndEmployer_companyName(companyName);
    }
    
	@PostMapping("/setActivetoPassive")
	public Result setActivetoPassive(@RequestParam int id) {
		return this.jobPostingService.setActivetoPassive(id);
	}

    @GetMapping("/getById/{id}")
    public DataResult<JobPosting> getById(@PathVariable("id") int id){
    	return this.jobPostingService.getById(id);
    }


    @GetMapping("getAllByCity_Name")
    public DataResult<List<JobPosting>> getAllByCity_Name(@RequestParam String name){
        return this.jobPostingService.getAllByCity_Name(name);
    }

    @GetMapping("getAllByCity_Id")
    public DataResult<List<JobPosting>> getAllByCity_Id(@RequestParam int id){
        return this.jobPostingService.getAllByCity_Id(id);
    }
    

    
}

















