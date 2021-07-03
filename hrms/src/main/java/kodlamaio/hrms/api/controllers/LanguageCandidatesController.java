package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageCandidate;
import kodlamaio.hrms.entities.concretes.dtos.languageCandidateDto.LanguageCandidateDto;

@RestController
@RequestMapping("/api/LanguageCandidate")
@CrossOrigin
public class LanguageCandidatesController {

	private LanguageCandidateService languageCandidateService;
	
	
	@Autowired
	public LanguageCandidatesController(LanguageCandidateService languageCandidateService) {
		super();
		this.languageCandidateService = languageCandidateService;
	}

	@GetMapping("/getAll")
	public DataResult<List<LanguageCandidate>> getAll(){
		return this.languageCandidateService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	DataResult<List<LanguageCandidate>> getByCandidateId(@RequestParam int candidateId){
		return this.languageCandidateService.getByCandidateId(candidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody LanguageCandidateDto languageCandidateDto){
		return ResponseEntity.ok(this.languageCandidateService.add(languageCandidateDto));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody LanguageCandidateDto languageCandidateDto){
		return ResponseEntity.ok(this.languageCandidateService.update(languageCandidateDto));
	}
	
	@PostMapping("delete")
	public Result delete (@RequestParam("id") int id) {
		return this.languageCandidateService.delete(id);
	}

	
	
	
	
}
