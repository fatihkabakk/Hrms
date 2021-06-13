package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	Result add(CandidateLanguage candidateLanguage);
	Result add(CandidateLanguage candidateLanguage, int candidateId);
	Result addAll(List<CandidateLanguage> candidateLanguages);
	Result addAll(List<CandidateLanguage> candidateLanguages, int candidateId);
	DataResult<List<CandidateLanguage>> getAll();
	DataResult<CandidateLanguage> getByCandidateId(int candidateId);
	DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);
}
