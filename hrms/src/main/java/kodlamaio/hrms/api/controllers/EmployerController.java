package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
   	public DataResult<List<Employer>> getAll(){
   		return this.employerService.getAll();
   	}
    
    @GetMapping("/getById")
   	public DataResult<Employer> getById(@RequestParam int id){
   		return this.employerService.getById(id);
   	}

   	@PostMapping("/update")
    public Result update(@RequestBody Employer employer){
        return this.employerService.update(employer);
    }
   	
   	@PostMapping("/changeStatusVerified")
	public Result changeIsVerifiedByEmployee(@RequestParam int id) {
		return this.employerService.statusChangeConfirmedByEmployee(id);
	}
   	
   	@GetMapping("/countById")
	public long  countById(@RequestParam int id) {
		return this.employerService.countById(id);
	}
   	
   	@GetMapping("/employerAllCount")
   	public long countGetAll() {
   		return this.employerService.countGetAll();
   	}
   	
   	@PostMapping("/uploadPhoto")
	public Result uploadPhoto(@RequestParam int employerId, @RequestParam("file") MultipartFile photoFile) {
		return this.employerService.uploadPhoto(employerId, photoFile);
	}
   
}
