package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPostingConfirm;


@RestController
@RequestMapping("/api/jobPostingConfirms")
public class JobPostingConfirmsController {

	private JobPostingConfirmService jobPostingConfirmService;

	@Autowired
	public JobPostingConfirmsController(JobPostingConfirmService jobPostingConfirmService) {
		super();
		this.jobPostingConfirmService = jobPostingConfirmService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPostingConfirm>> getAll(){
		return this.jobPostingConfirmService.getAll();
	}
	

	@PostMapping("/confirm")
	public ResponseEntity<?> add(@RequestBody JobPostingConfirm jobPostingConfirm){
		return ResponseEntity.ok(this.jobPostingConfirmService.confirm(jobPostingConfirm));
	}
	
	
	
}
