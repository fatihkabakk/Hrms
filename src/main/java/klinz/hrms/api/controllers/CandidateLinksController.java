package klinz.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.CandidateLinkService;
import klinz.hrms.entities.concretes.CandidateLink;

@RestController
@RequestMapping("/api/candidatelinks")
public class CandidateLinksController {
	
	private CandidateLinkService candidateLinkService;
	
	@Autowired
	public CandidateLinksController(CandidateLinkService candidateLinkService) {
		super();
		this.candidateLinkService = candidateLinkService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateLink candidateLink, int candidateId) {
		return ResponseEntity.ok(this.candidateLinkService.add(candidateLink, candidateId));
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@RequestBody List<@Valid CandidateLink> candidateLinks, int candidateId) {
		return ResponseEntity.ok(this.candidateLinkService.addAll(candidateLinks, candidateId));
	}
	
}
