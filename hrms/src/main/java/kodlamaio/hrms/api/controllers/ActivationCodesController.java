package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activationCodes")
@CrossOrigin
public class ActivationCodesController {

	@Autowired
	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	@PostMapping("/verify")
	public Result verify(@RequestParam String code) {
		Result result = activationCodeService.verify(code);
		
		return result;
	}
	
	
	
}
