package kodlamaio.hrms.api.controllers;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/employees")
@CrossOrigin
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@Valid @RequestBody Employer employer) throws MessagingException
	{
		return authService.registerEmployer(employer);
	}

	@PostMapping("/registerCandidate")
	public Result registerCandidate(@Valid @RequestBody Candidate candidate) throws MessagingException
	{
		return authService.registerCandidate(candidate);
	}
	
	
}
