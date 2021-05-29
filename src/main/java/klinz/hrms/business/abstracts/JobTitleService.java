package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
