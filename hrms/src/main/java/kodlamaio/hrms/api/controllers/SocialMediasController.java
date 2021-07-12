package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.dtos.socialMediasDto.SocialMediaDto;
import kodlamaio.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("/api/socialMedias")
@CrossOrigin
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
//
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SocialMediaDto socialMedia){
		return ResponseEntity.ok(this.socialMediaService.add(socialMedia));
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody SocialMediaDto socialMedia){
		return ResponseEntity.ok(this.socialMediaService.update(socialMedia));
	}
	

	@PostMapping("delete")
	public Result delete (@RequestParam("id") int id) {
		return this.socialMediaService.delete(id);
	}
	
}
