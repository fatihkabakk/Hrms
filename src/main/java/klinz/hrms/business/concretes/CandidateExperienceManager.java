package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateExperienceService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateExperienceDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {
	
	private CandidateExperienceDao candidateExperienceDao;
	
	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
		super();
		this.candidateExperienceDao = candidateExperienceDao;
	}
	
	@Override
	public Result add(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
		return new SuccessResult("Candidate Experience saved");
	}

	@Override
	public Result addAll(List<CandidateExperience> candidateExperiences) {
		this.candidateExperienceDao.saveAll(candidateExperiences);
		return new SuccessResult("Candidate Experiences saved");
	}

	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.findAll(), "Candidate Experiences listed");
	}

	@Override
	public DataResult<CandidateExperience> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateExperience>(this.candidateExperienceDao.getByCandidateId(candidateId), "Candidate's Experience listed");
	}

	@Override
	public DataResult<List<CandidateExperience>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.getAllByCandidateId(candidateId), "Candidate's Experiences listed");
	}

	@Override
	public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId), "Candidate's Experiences listed and ordered");
	}

	@Override
	public Result add(CandidateExperience candidateExperience, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateExperience.setCandidate(candidate);
		return this.add(candidateExperience);
	}

	@Override
	public Result addAll(List<CandidateExperience> candidateExperiences, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateExperiences.forEach(candidateExperience -> candidateExperience.setCandidate(candidate));
		return this.addAll(candidateExperiences);
	}

}
