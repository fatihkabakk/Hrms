package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {
	Result add(CandidateExperience candidateExperience);
	Result add(CandidateExperience candidateExperience, int candidateId);
	Result addAll(List<CandidateExperience> candidateExperiences);
	Result addAll(List<CandidateExperience> candidateExperiences, int candidateId);
	DataResult<List<CandidateExperience>> getAll();
	DataResult<CandidateExperience> getByCandidateId(int candidateId);
	DataResult<List<CandidateExperience>> getAllByCandidateId(int candidateId);
	DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
