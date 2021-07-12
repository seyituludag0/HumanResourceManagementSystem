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

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;

@RestController
@RequestMapping("/api/schooldepartments/")
@CrossOrigin
public class SchoolDepartmentsController {

	private SchoolDepartmentService schoolDepartmentService;

	@Autowired
	public SchoolDepartmentsController(SchoolDepartmentService schoolDepartmentService) {
		super();
		this.schoolDepartmentService = schoolDepartmentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SchoolDepartment>> getAll(){
		return this.schoolDepartmentService.getAll();
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody SchoolDepartment schoolDepartment){
		return ResponseEntity.ok(this.schoolDepartmentService.add(schoolDepartment));
	}
}
