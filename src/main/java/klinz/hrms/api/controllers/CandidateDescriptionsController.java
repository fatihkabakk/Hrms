package klinz.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.CandidateDescriptionService;
import klinz.hrms.entities.concretes.CandidateDescription;

@RestController
@RequestMapping("/api/candidatedescriptions")
public class CandidateDescriptionsController {
	
	private CandidateDescriptionService candidateDescriptionService;

	@Autowired
	public CandidateDescriptionsController(CandidateDescriptionService candidateDescriptionService) {
		super();
		this.candidateDescriptionService = candidateDescriptionService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateDescription candidateDescription, int candidateId) {
		return ResponseEntity.ok(this.candidateDescriptionService.add(candidateDescription, candidateId));
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.candidateDescriptionService.getByCandidateId(candidateId));
	}
	
}
