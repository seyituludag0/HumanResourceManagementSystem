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

import kodlamaio.hrms.business.abstracts.AbilityCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.AbilityCandidate;
import kodlamaio.hrms.entities.concretes.dtos.abilityCandidateDto.AbilityCandidateDto;

@RestController
@RequestMapping("/api/abilityCandidates")
@CrossOrigin
public class AbilityCandidatesController {

	private AbilityCandidateService abilityCandidateService;

	@Autowired
	public AbilityCandidatesController(AbilityCandidateService abilityCandidateService) {
		super();
		this.abilityCandidateService = abilityCandidateService;
	}
	

	@GetMapping("/getAll")
	public DataResult<List<AbilityCandidate>> getAll(){
		return this.abilityCandidateService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId){
		return this.abilityCandidateService.getByCandidateId(candidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody AbilityCandidateDto abilityCandidateDto){
		return ResponseEntity.ok(this.abilityCandidateService.add(abilityCandidateDto));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody AbilityCandidateDto abilityCandidateDto){
		return ResponseEntity.ok(this.abilityCandidateService.update(abilityCandidateDto));
	}
	
	
}
