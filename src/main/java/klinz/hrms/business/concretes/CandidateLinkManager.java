package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateLinkService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateLinkDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateLink;

@Service
public class CandidateLinkManager implements CandidateLinkService {
	
	private CandidateLinkDao candidateLinkDao;
	
	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
		super();
		this.candidateLinkDao = candidateLinkDao;
	}

	@Override
	public Result add(CandidateLink candidateLink) {
		this.candidateLinkDao.save(candidateLink);
		return new SuccessResult("Candidate Link saved");
	}

	@Override
	public Result addAll(List<CandidateLink> candidateLinks) {
		this.candidateLinkDao.saveAll(candidateLinks);
		return new SuccessResult("Candidate Links saved");
	}

	@Override
	public DataResult<List<CandidateLink>> getAll() {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.findAll(), "Candidate Links listed");
	}

	@Override
	public DataResult<CandidateLink> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateLink>(this.candidateLinkDao.getByCandidateId(candidateId), "Candidate's Link listed");
	}

	@Override
	public DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.getAllByCandidateId(candidateId), "Candidate's Links listed");
	}

	@Override
	public Result add(CandidateLink candidateLink, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateLink.setCandidate(candidate);
		return this.add(candidateLink);
	}

	@Override
	public Result addAll(List<CandidateLink> candidateLinks, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateLinks.forEach(candidateLink -> candidateLink.setCandidate(candidate));
		return this.addAll(candidateLinks);
	}
	
}
