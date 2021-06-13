package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateKnowledgeService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateKnowledgeDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateKnowledge;

@Service
public class CandidateKnowledgeManager implements CandidateKnowledgeService {
	
	private CandidateKnowledgeDao candidateKnowledgeDao;
	
	@Autowired
	public CandidateKnowledgeManager(CandidateKnowledgeDao candidateKnowledgeDao) {
		super();
		this.candidateKnowledgeDao = candidateKnowledgeDao;
	}

	@Override
	public Result add(CandidateKnowledge candidateKnowledge) {
		this.candidateKnowledgeDao.save(candidateKnowledge);
		return new SuccessResult("Candidate Knowledge saved");
	}

	@Override
	public Result addAll(List<CandidateKnowledge> candidateKnowledges) {
		this.candidateKnowledgeDao.saveAll(candidateKnowledges);
		return new SuccessResult("Candidate Knowledges saved");
	}

	@Override
	public DataResult<List<CandidateKnowledge>> getAll() {
		return new SuccessDataResult<List<CandidateKnowledge>>(this.candidateKnowledgeDao.findAll(), "Candidate Knowledges listed");
	}

	@Override
	public DataResult<CandidateKnowledge> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateKnowledge>(this.candidateKnowledgeDao.getByCandidateId(candidateId), "Candidate's Knowledge listed");
	}

	@Override
	public DataResult<List<CandidateKnowledge>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateKnowledge>>(this.candidateKnowledgeDao.getAllByCandidateId(candidateId), "Candidate Knowledges listed");
	}

	@Override
	public Result add(CandidateKnowledge candidateKnowledge, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateKnowledge.setCandidate(candidate);
		return this.add(candidateKnowledge);
	}

	@Override
	public Result addAll(List<CandidateKnowledge> candidateKnowledges, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateKnowledges.forEach(candidateKnowledge -> candidateKnowledge.setCandidate(candidate));
		return this.addAll(candidateKnowledges);
	}

}
