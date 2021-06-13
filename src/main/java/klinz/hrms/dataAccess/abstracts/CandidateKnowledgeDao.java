package klinz.hrms.dataAccess.abstracts;

import klinz.hrms.entities.concretes.CandidateKnowledge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateKnowledgeDao extends JpaRepository<CandidateKnowledge, Integer> {
	CandidateKnowledge getByCandidateId(int candidateId);
	List<CandidateKnowledge> getAllByCandidateId(int candidateId);
}
