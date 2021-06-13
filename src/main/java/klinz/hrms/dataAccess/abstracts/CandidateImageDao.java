package klinz.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.CandidateImage;

public interface CandidateImageDao extends JpaRepository<CandidateImage, Integer> {
	CandidateImage getByCandidateId(int candidateId);
}
