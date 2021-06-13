package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateEducationService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateEducationDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService {
	
	private CandidateEducationDao candidateEducationDao;
	
	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("Candidate Education saved");
	}

	@Override
	public Result addAll(List<CandidateEducation> candidateEducations) {
		this.candidateEducationDao.saveAll(candidateEducations);
		return new SuccessResult("Candidate Educations saved");
	}
	
	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll(), "Candidate Educations listed");
	}

	@Override
	public DataResult<CandidateEducation> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateEducation>(this.candidateEducationDao.getByCandidateId(candidateId), "Candidate's Education listed");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getAllByCandidateId(candidateId), "Candidate's Educations listed");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getAllByCandidateIdOrderByGraduateYearDesc(candidateId), "Candidate's Educations listed and ordered");
	}

	@Override
	public Result add(CandidateEducation candidateEducation, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateEducation.setCandidate(candidate);
		return this.add(candidateEducation);
	}

	@Override
	public Result addAll(List<CandidateEducation> candidateEducations, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateEducations.forEach(candidateEducation -> candidateEducation.setCandidate(candidate));
		return this.addAll(candidateEducations);
	}
	
}
