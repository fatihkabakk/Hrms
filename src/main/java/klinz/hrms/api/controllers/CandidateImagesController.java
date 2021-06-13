package klinz.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import klinz.hrms.business.abstracts.CandidateImageService;

@RestController
@RequestMapping("/api/candidateimages")
public class CandidateImagesController {
	
	private CandidateImageService candidateImageService;
	
	@Autowired
	public CandidateImagesController(CandidateImageService candidateImageService) {
		super();
		this.candidateImageService = candidateImageService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody MultipartFile file, int candidateId) {
		return ResponseEntity.ok(this.candidateImageService.add(file, candidateId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.candidateImageService.getAll());
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(int candidateId) {
		return ResponseEntity.ok(this.candidateImageService.getByCandidateId(candidateId));
	}
}
