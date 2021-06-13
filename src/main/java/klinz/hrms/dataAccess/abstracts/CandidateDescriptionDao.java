package klinz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.CandidateDescription;

public interface CandidateDescriptionDao extends JpaRepository<CandidateDescription, Integer> {
	CandidateDescription getByCandidateId(int candidateId);
}
