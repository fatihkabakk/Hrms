package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.JobAnnouncementService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.JobAnnouncementDao;
import klinz.hrms.entities.concretes.JobAnnouncement;

@Service
public class JobAnnouncementManager implements JobAnnouncementService {

	private JobAnnouncementDao jobAnnouncementDao;
	
	@Autowired
	public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao) {
		super();
		this.jobAnnouncementDao = jobAnnouncementDao;
	}

	@Override
	public Result changeState(int id) {
		JobAnnouncement jobAnnouncement = this.jobAnnouncementDao.getById(id);
		Result result = checkIfAnnouncementExists(jobAnnouncement);
		if (result.isSuccess()) {
			jobAnnouncement.setActive(!jobAnnouncement.isActive());
			this.jobAnnouncementDao.save(jobAnnouncement);
			return new SuccessResult("State has been changed");
		}
		return new ErrorResult("Job Announcement is not found");
	}

	@Override
	public Result add(JobAnnouncement jobAnnouncement) {
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Job Announcement is added");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAll() {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAll(), "Job Announcements are listed");
	}

	@Override
	public DataResult<JobAnnouncement> getById(int id) {
		return new SuccessDataResult<JobAnnouncement>(this.jobAnnouncementDao.getById(id), "Job Announcement is listed");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActive() {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.getByIsActiveTrue(), "Active Job Announcements are listed");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveOrdered() {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.getByIsActiveTrueOrderByCreatedDateDesc(), "Ordered active Job Announcements are listed");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByEmployerIdAndIsActive(int employerId) {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.getByEmployer_IdAndIsActiveTrue(employerId), "Employer's Active Job Announcements are listed");
	}
	
	private Result checkIfAnnouncementExists(JobAnnouncement jobAnnouncement) {
		if (jobAnnouncement != null) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

}
