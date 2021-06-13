package klinz.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.JobAnnouncementService;
import klinz.hrms.entities.concretes.JobAnnouncement;
import klinz.hrms.core.utilities.results.ErrorDataResult;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Exceptions");
		return errors;
	}
	
}
