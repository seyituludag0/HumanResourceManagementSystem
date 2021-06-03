package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linkTypes")
public class LinkTypesController {

	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypesController(LinkTypeService linkTypeService) {
		super();
		this.linkTypeService = linkTypeService;
	}
	

	
	@GetMapping("/getAll")
	public DataResult<List<LinkType>> getAll(){
		return this.linkTypeService.getAll();
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody LinkType linkType){
		return ResponseEntity.ok(this.linkTypeService.add(linkType));
	}
	
}
