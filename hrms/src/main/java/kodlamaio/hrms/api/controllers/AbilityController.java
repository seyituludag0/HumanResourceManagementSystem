package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {

	private AbilityService abilityService;

	public AbilityController(AbilityService abilityService) {
		super();
		this.abilityService = abilityService;
	}
	

	@GetMapping("/getAll")
	public DataResult<List<Ability>> getAll(){
		return this.abilityService.getAll();
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Ability ability){
		return ResponseEntity.ok(this.abilityService.add(ability));
	}
}
