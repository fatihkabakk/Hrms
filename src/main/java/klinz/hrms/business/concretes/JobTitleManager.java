package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.JobTitleService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.dataAccess.abstracts.JobTitleDao;
import klinz.hrms.entities.concretes.JobTitle;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Job positions listed");
	}
	
	@Override
	public DataResult<JobTitle> getByJobName(String jobName) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getByJobName(jobName), "Job position listed");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		var result = this.jobTitleDao.getByJobName(jobTitle.getJobName());
		if (result != null) {
			return new ErrorResult("Job position exists");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job position is saved");
	}

}
