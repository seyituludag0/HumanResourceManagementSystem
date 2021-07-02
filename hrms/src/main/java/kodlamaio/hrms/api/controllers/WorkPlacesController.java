package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkplaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkPlace;

@RestController
@RequestMapping("/api/workplaces")
@CrossOrigin
public class WorkPlacesController {

	private WorkplaceService workplaceService;

	@Autowired
	public WorkPlacesController(WorkplaceService workplaceService) {
		super();
		this.workplaceService = workplaceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkPlace>> getAll(){
		return this.workplaceService.getAll();
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkPlace workplace){
		return ResponseEntity.ok(this.workplaceService.add(workplace));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody WorkPlace workplace){
		return ResponseEntity.ok(this.workplaceService.update(workplace));
	}
}
