package klinz.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer> {
	JobAnnouncement getById(int id);
	List<JobAnnouncement> getByIsActiveTrue();
	List<JobAnnouncement> getByIsActiveTrueOrderByCreatedDateDesc();
	List<JobAnnouncement> getByEmployer_IdAndIsActiveTrue(int employerId);
}
