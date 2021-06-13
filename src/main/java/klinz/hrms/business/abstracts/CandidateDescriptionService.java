package klinz.hrms.business.abstracts;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateDescription;

public interface CandidateDescriptionService {
	Result add(CandidateDescription candidateDescription);
	Result add(CandidateDescription candidateDescription, int candidateId);
	DataResult<CandidateDescription> getByCandidateId(int candidateId);
}
