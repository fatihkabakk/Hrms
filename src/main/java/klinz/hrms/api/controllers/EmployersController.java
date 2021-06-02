package klinz.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import klinz.hrms.business.abstracts.EmployerService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.Employer;
import klinz.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return this.employerService.add(employerForRegisterDto);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
}
