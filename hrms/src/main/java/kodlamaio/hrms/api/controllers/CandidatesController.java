package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid Candidate candidate) {
		return this.candidateService.add(candidate);
	}

	@PostMapping("/update")
	public Result update(@RequestBody @Valid Candidate candidate) {
		return this.candidateService.update(candidate);
	}

	@PostMapping("/delete/{id}")
	public Result delete(@PathVariable("id") int id){
		return this.candidateService.delete(id);
	}

}
