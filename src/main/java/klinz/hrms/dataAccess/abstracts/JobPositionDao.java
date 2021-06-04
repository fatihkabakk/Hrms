package klinz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	JobPosition getByJobName(String jobName);
}
