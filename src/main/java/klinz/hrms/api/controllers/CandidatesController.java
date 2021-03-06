package klinz.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.dtos.CandidateForRegisterDto;
import klinz.hrms.business.abstracts.CandidateService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateForRegisterDto candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
	
}
