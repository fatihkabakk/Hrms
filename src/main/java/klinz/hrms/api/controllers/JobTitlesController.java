package klinz.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klinz.hrms.business.abstracts.JobTitleService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTame) {
		return this.jobTitleService.add(jobTame);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobTitleService.getAll();
	}
	
}
