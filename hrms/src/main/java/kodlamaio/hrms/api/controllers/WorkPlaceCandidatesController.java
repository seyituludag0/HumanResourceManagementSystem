package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkPlaceCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkPlaceCandidate;
import kodlamaio.hrms.entities.concretes.dtos.workPlaceCandidateDto.WorkPlaceCandidateDto;

@RestController
@RequestMapping("/api/workPlaceCandidates")
@CrossOrigin
public class WorkPlaceCandidatesController {

	private WorkPlaceCandidateService workplaceCandidateService;

	@Autowired
	public WorkPlaceCandidatesController(WorkPlaceCandidateService workplaceCandidateService) {
		super();
		this.workplaceCandidateService = workplaceCandidateService;
	}
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<WorkPlaceCandidate>> getAll(){
		return this.workplaceCandidateService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<WorkPlaceCandidate>> getByCandidateId(int candidateId){
		return this.workplaceCandidateService.getByCandidateId(candidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkPlaceCandidateDto workPlaceCandidateDto){
		return ResponseEntity.ok(this.workplaceCandidateService.add(workPlaceCandidateDto));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody WorkPlaceCandidateDto workPlaceCandidateDto){
		return ResponseEntity.ok(this.workplaceCandidateService.update(workPlaceCandidateDto));
	}
	
	
	
	
	
	
}
