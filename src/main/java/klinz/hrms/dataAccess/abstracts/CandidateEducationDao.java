package klinz.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer> {
	CandidateEducation getByCandidateId(int candidateId);
	List<CandidateEducation> getAllByCandidateId(int candidateId);
	List<CandidateEducation> getAllByCandidateIdOrderByGraduateYearDesc(int candidateId);
}
