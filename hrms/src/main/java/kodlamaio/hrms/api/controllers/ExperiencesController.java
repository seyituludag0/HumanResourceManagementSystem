package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@GetMapping("getByCandidateIdOrderByLeaveDateDesc") 
	public DataResult<List<Experience>> getByCandidate_IdOrderByLeaveDateDesc(int candidateId){
		return this.experienceService.getByCandidate_IdOrderByLeaveDateDesc(candidateId);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Experience experience){
		return ResponseEntity.ok(this.experienceService.add(experience));
	}
}
