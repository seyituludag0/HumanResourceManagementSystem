package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

@RestController
@RequestMapping("/api/favoriteJobPostings")
@CrossOrigin
public class FavoriteJobPostingsController {

	private FavoriteJobPostingService favoriteJobPostingService;

	@Autowired
	public FavoriteJobPostingsController(FavoriteJobPostingService favoriteJobPostingService) {
		super();
		this.favoriteJobPostingService = favoriteJobPostingService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestParam int candidateId, @RequestParam int jobPostingId) {
		return ResponseEntity.ok(this.favoriteJobPostingService.add(candidateId, jobPostingId));
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int candidateId, @RequestParam int jobPostingId) {
		return this.favoriteJobPostingService.delete(candidateId, jobPostingId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<FavoriteJobPosting>> getAll(){
		return this.favoriteJobPostingService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<FavoriteJobPosting> getById(@RequestParam int id){
		return this.favoriteJobPostingService.getById(id);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<FavoriteJobPosting>> getByCandidateId(@RequestParam int candidateId){
		return this.favoriteJobPostingService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getByAdvertId")
	public DataResult<List<FavoriteJobPosting>> getByJobPostingId(@RequestParam int jobPosting){
		return this.favoriteJobPostingService.getByJobPostingId(jobPosting);
	}
	
	@GetMapping("/getByCandidateIdAndJobPostingId")
	public DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId){
		return this.favoriteJobPostingService.getByCandidateIdAndJobPostingId(candidateId, jobPostingId);
	}
	
}
