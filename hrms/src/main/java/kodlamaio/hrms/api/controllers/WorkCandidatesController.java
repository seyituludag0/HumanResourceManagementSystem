package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkplaceCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkplaceCandidate;

@RestController
@RequestMapping("/api/WorkCandidates")
public class WorkCandidatesController {

	private WorkplaceCandidateService workplaceCandidateService;

	@Autowired
	public WorkCandidatesController(WorkplaceCandidateService workplaceCandidateService) {
		super();
		this.workplaceCandidateService = workplaceCandidateService;
	}
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<WorkplaceCandidate>> getAll(){
		return this.workplaceCandidateService.getAll();
	}
	
	@GetMapping("getByCandidateId")
	public DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId){
		return this.workplaceCandidateService.getByCandidateId(candidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkplaceCandidate workplaceCandidate){
		return ResponseEntity.ok(this.workplaceCandidateService.add(workplaceCandidate));
	}
	
	
	
	
	
	
}
