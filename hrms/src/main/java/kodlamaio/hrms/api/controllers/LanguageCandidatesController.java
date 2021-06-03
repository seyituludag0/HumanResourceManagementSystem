package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.LanguageCandidate;

@RestController
@RequestMapping("/api/LanguageCandidate")
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
	public ResponseEntity<?> add(@RequestBody LanguageCandidate languageCandidate){
		return ResponseEntity.ok(this.languageCandidateService.add(languageCandidate));
	}
	
	
	
	
	
}
