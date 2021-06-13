package klinz.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateDescriptionService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateDescriptionDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateDescription;

@Service
public class CandidateDescriptionManager implements CandidateDescriptionService {

	private CandidateDescriptionDao candidateDescriptionDao;
	
	@Autowired
	public CandidateDescriptionManager(CandidateDescriptionDao candidateDescriptionDao) {
		super();
		this.candidateDescriptionDao = candidateDescriptionDao;
	}

	@Override
	public Result add(CandidateDescription candidateDescription) {
		this.candidateDescriptionDao.save(candidateDescription);
		return new SuccessResult("Candidate Description saved");
	}
	
	@Override
	public Result add(CandidateDescription candidateDescription, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateDescription.setCandidate(candidate);
		return this.add(candidateDescription);
	}

	@Override
	public DataResult<CandidateDescription> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateDescription>(this.candidateDescriptionDao.getByCandidateId(candidateId));
	}

}
