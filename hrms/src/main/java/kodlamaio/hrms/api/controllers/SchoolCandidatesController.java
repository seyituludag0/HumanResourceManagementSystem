package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;
import kodlamaio.hrms.entities.concretes.dtos.candidateSchoolsDto.SchoolCandidateDto;

@RestController
@RequestMapping("/api/schoolcandidate")
@CrossOrigin
public class SchoolCandidatesController {

	private SchoolCandidateService schoolCandidateService;

	@Autowired
	public SchoolCandidatesController(SchoolCandidateService schoolCandidateService) {
		super();
		this.schoolCandidateService = schoolCandidateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SchoolCandidate>> getAll(){
		return this.schoolCandidateService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<SchoolCandidate>> getByCandidateId(@RequestParam int candidateId){
		return this.schoolCandidateService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getByCandidateIdOrderByDateOfGraduationDesc")
	public DataResult<List<SchoolCandidate>> getByCandidateIdOrderByDateOfGraduationDesc(int candidateId){
		return this.schoolCandidateService.getByCandidate_IdOrderByDateOfGraduationDesc(candidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody SchoolCandidateDto schoolCandidateDto){
		return ResponseEntity.ok(this.schoolCandidateService.add(schoolCandidateDto));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody SchoolCandidateDto schoolCandidateDto){
		return ResponseEntity.ok(this.schoolCandidateService.update(schoolCandidateDto));
	}

	@PostMapping("delete")
	public Result delete (@RequestParam("id") int id) {
		return this.schoolCandidateService.delete(id);
	}
	
}
