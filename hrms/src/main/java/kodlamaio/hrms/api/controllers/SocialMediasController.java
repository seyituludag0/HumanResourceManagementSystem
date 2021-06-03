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

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediasController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	DataResult<List<SocialMedia>> getByCandidateId(@RequestParam int candidateId){
		return this.socialMediaService.getByCandidateId(candidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody SocialMedia socialMedia){
		return ResponseEntity.ok(this.socialMediaService.add(socialMedia));
	}
}
