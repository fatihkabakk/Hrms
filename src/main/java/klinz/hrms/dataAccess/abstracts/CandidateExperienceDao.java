package klinz.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {
	CandidateExperience getByCandidateId(int candidateId);
	List<CandidateExperience> getAllByCandidateId(int candidateId);
	List<CandidateExperience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
