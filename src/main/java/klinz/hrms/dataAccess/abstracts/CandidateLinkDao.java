package klinz.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer> {
	CandidateLink getByCandidateId(int candidateId);
	List<CandidateLink> getAllByCandidateId(int candidateId);
}
