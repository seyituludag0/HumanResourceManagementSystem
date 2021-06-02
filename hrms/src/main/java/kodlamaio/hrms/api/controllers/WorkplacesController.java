package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkplaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Workplace;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplacesController {

	private WorkplaceService workplaceService;

	@Autowired
	public WorkplacesController(WorkplaceService workplaceService) {
		super();
		this.workplaceService = workplaceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Workplace>> getAll(){
		return this.workplaceService.getAll();
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Workplace workplace){
		return ResponseEntity.ok(this.workplaceService.add(workplace));
	}
}
