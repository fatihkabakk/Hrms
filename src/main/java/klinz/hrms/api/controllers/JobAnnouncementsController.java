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

import klinz.hrms.business.abstracts.JobAnnouncementService;
import klinz.hrms.entities.concretes.JobAnnouncement;

@RestController
@RequestMapping("/api/jobannouncements")
public class JobAnnouncementsController {
	
	private JobAnnouncementService jobAnnouncementService;

	@Autowired
	public JobAnnouncementsController(JobAnnouncementService jobAnnouncementService) {
		super();
		this.jobAnnouncementService = jobAnnouncementService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAnnouncement jobAnnouncement) {
		return ResponseEntity.ok(this.jobAnnouncementService.add(jobAnnouncement));
	}
	
	@GetMapping("/changeState")
	public ResponseEntity<?> changeState(int id) {
		return ResponseEntity.ok(this.jobAnnouncementService.changeState(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobAnnouncementService.getAll());
	}
	
	@GetMapping("/getByIsActive")
	public ResponseEntity<?> getByIsActive() {
		return ResponseEntity.ok(this.jobAnnouncementService.getByIsActive());
	}
	
	@GetMapping("/getByIsActiveOrdered")
	public ResponseEntity<?> getByIsActiveOrdered() {
		return ResponseEntity.ok(this.jobAnnouncementService.getByIsActiveOrdered());
	}
	
	@GetMapping("/getByEmployerIdAndIsActive")
	public ResponseEntity<?> getByEmployerIdAndIsActive(@RequestParam int employerId) {
		return ResponseEntity.ok(this.jobAnnouncementService.getByEmployerIdAndIsActive(employerId));
	}
	
}
