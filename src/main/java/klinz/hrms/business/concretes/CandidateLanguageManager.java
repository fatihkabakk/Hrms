package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateLanguageService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateLanguageDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidateLanguageDao;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Candidate Language saved");
	}

	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguages) {
		this.candidateLanguageDao.saveAll(candidateLanguages);
		return new SuccessResult("Candidate Languages saved");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll(), "Candidate Languages listed");
	}

	@Override
	public DataResult<CandidateLanguage> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateLanguage>(this.candidateLanguageDao.getByCandidateId(candidateId), "Candidate's Language listed");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.getAllByCandidateId(candidateId), "Candidate's Languages listed");
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateLanguage.setCandidate(candidate);
		return this.add(candidateLanguage);
	}

	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguages, int candidateId) {
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		candidateLanguages.forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
		return this.addAll(candidateLanguages);
	}

}
