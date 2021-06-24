package kodlamaio.hrms.api.controllers;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	

	
	@PostMapping("/registerCandidate")
	public ResponseEntity<?> registerCandidate(@RequestBody Candidate candidate) throws MessagingException{
		
		Result result = this.authService.registerCandidate(candidate);
		if(result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
		
	}
	
	
	
	
	@PostMapping("/registerEmployer")
	public ResponseEntity<?> registerEmployer(@RequestBody Employer employer) throws MessagingException{
		
		Result result = this.authService.registerEmployer(employer);
		if(result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
		
	}
	
}
