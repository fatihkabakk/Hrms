package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateKnowledge;

public interface CandidateKnowledgeService {
	Result add(CandidateKnowledge candidateKnowledge);
	Result add(CandidateKnowledge candidateKnowledge, int candidateId);
	Result addAll(List<CandidateKnowledge> candidateKnowledges);
	Result addAll(List<CandidateKnowledge> candidateKnowledges, int candidateId);
	DataResult<List<CandidateKnowledge>> getAll();
	DataResult<CandidateKnowledge> getByCandidateId(int candidateId);
	DataResult<List<CandidateKnowledge>> getAllByCandidateId(int candidateId);
}
