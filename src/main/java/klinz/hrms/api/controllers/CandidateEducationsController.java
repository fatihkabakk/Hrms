package klinz.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.CandidateEducationService;
import klinz.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateeducations")
public class CandidateEducationsController {
	
	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateEducation candidateEducation, int candidateId) {
		return ResponseEntity.ok(this.candidateEducationService.add(candidateEducation, candidateId));
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@RequestBody List<@Valid CandidateEducation> candidateEducations, int candidateId) {
		return ResponseEntity.ok(this.candidateEducationService.addAll(candidateEducations, candidateId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.candidateEducationService.getAll());
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.candidateEducationService.getByCandidateId(candidateId));
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.candidateEducationService.getAllByCandidateId(candidateId));
	}
	
}
