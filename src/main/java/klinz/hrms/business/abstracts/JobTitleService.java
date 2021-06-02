package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	Result add(JobTitle jobTitle);
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> getByJobName(String jobName);
}
