package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageCandiateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.LanguageCandiate;

@RestController
@RequestMapping("/api/LanguageCandidate")
public class LanguageCandidatesController {

	private LanguageCandiateService languageCandidateService;
	
	
	@Autowired
	public LanguageCandidatesController(LanguageCandiateService languageCandidateService) {
		super();
		this.languageCandidateService = languageCandidateService;
	}

	@GetMapping("/getAll")
	public DataResult<List<LanguageCandiate>> getAll(){
		return this.languageCandidateService.getAll();
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody LanguageCandiate languageCandiate){
		return ResponseEntity.ok(this.languageCandidateService.add(languageCandiate));
	}
	
	
	
	
	
}
