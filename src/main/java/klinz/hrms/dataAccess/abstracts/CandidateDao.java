package klinz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate getByEmail(String email);
	Candidate getById(int candidateId);
	Candidate getByIdentityNumber(String identityNumber);
}
