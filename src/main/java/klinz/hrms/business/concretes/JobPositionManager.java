package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.JobPositionService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.dataAccess.abstracts.JobPositionDao;
import klinz.hrms.entities.concretes.JobPosition;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed");
	}
	
	@Override
	public DataResult<JobPosition> getByJobName(String jobName) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getByJobName(jobName), "Job position listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		var result = this.jobPositionDao.getByJobName(jobPosition.getJobName());
		if (result != null) {
			return new ErrorResult("Job position exists");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position is saved");
	}

}
