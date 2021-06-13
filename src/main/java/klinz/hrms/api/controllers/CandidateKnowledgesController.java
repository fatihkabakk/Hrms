package klinz.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.CandidateKnowledgeService;
import klinz.hrms.entities.concretes.CandidateKnowledge;

@RestController
@RequestMapping("/api/candidateknowledges")
public class CandidateKnowledgesController {
	
	private CandidateKnowledgeService candidateKnowledgeService;

	@Autowired
	public CandidateKnowledgesController(CandidateKnowledgeService candidateKnowledgeService) {
		super();
		this.candidateKnowledgeService = candidateKnowledgeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateKnowledge candidateKnowledge, int candidateId) {
		return ResponseEntity.ok(this.candidateKnowledgeService.add(candidateKnowledge, candidateId));
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@RequestBody List<@Valid CandidateKnowledge> candidateKnowledges, int candidateId) {
		return ResponseEntity.ok(this.candidateKnowledgeService.addAll(candidateKnowledges, candidateId));
	}
	
}
