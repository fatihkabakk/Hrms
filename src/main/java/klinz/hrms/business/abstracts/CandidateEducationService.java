package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationService {
	Result add(CandidateEducation candidateEducation);
	Result add(CandidateEducation candidateEducation, int candidateId);
	Result addAll(List<CandidateEducation> candidateEducations);
	Result addAll(List<CandidateEducation> candidateEducations, int candidateId);
	DataResult<List<CandidateEducation>> getAll();
	DataResult<CandidateEducation> getByCandidateId(int candidateId);
	DataResult<List<CandidateEducation>> getAllByCandidateId(int candidateId);
	DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
