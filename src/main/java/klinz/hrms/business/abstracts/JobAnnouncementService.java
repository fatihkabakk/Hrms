package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementService {
	Result changeState(int id);
	Result add(JobAnnouncement jobAnnouncement);
	DataResult<List<JobAnnouncement>> getAll();
	DataResult<JobAnnouncement> getById(int id);
	DataResult<List<JobAnnouncement>> getByIsActive();
	DataResult<List<JobAnnouncement>> getByIsActiveOrdered();
	DataResult<List<JobAnnouncement>> getByEmployerIdAndIsActive(int employerId);
}
