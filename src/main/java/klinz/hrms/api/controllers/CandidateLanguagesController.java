package klinz.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.CandidateLanguageService;
import klinz.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidatelanguages")
public class CandidateLanguagesController {
	
	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateLanguage candidateLanguage, int candidateId) {
		return ResponseEntity.ok(this.candidateLanguageService.add(candidateLanguage, candidateId));
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@RequestBody List<@Valid CandidateLanguage> candidateLanguages, int candidateId) {
		return ResponseEntity.ok(this.candidateLanguageService.addAll(candidateLanguages, candidateId));
	}
}
