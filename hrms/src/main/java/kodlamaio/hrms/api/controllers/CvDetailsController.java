package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CvDetail;

@RestController
@RequestMapping("/api/cvDetails")
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
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvDetail cvDetail){
		return ResponseEntity.ok(this.cvDetailService.add(cvDetail));
	}
	
	
}
