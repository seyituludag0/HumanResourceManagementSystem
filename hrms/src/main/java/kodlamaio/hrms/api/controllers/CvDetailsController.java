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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvDetail;

@RestController
@RequestMapping("/api/cvDetails")
@CrossOrigin
public class CvDetailsController {

	private CvDetailService cvDetailService;

	@Autowired
	public CvDetailsController(CvDetailService cvDetailService) {
		super();
		this.cvDetailService = cvDetailService;
	}
	

	@GetMapping("/getAll")
	public DataResult<List<CvDetail>> getAll(){
		return this.cvDetailService.getAll();
	}

	@GetMapping("/getByCandidateId")
	public DataResult<CvDetail> getByCandidateId(@RequestParam int candidateId){
		return this.cvDetailService.getByCandidateId(candidateId);
	}

	@PostMapping("/uploadPhoto")
	public Result uploadPhoto(@RequestParam int candidateId, @RequestParam("file") MultipartFile photoFile) {
		return this.cvDetailService.uploadPhoto(candidateId, photoFile);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvDetail cvDetail){
		return ResponseEntity.ok(this.cvDetailService.add(cvDetail));
	}
	
	
}
