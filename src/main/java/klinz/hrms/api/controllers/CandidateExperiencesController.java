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

import klinz.hrms.business.abstracts.CandidateExperienceService;
import klinz.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/candidateexperiences")
public class CandidateExperiencesController {
	
	private CandidateExperienceService candidateExperienceService;

	@Autowired
	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateExperience candidateExperience, int candidateId) {
		return ResponseEntity.ok(this.candidateExperienceService.add(candidateExperience, candidateId));
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@RequestBody List<@Valid CandidateExperience> candidateExperiences, int candidateId) {
		return ResponseEntity.ok(this.candidateExperienceService.addAll(candidateExperiences, candidateId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.candidateExperienceService.getAll());
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(int candidateId) {
		return ResponseEntity.ok(this.candidateExperienceService.getByCandidateId(candidateId));
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.candidateExperienceService.getAllByCandidateId(candidateId));
	}
	
}
