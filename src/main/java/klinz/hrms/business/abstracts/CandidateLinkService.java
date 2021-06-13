package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkService {
	Result add(CandidateLink candidateLink);
	Result add(CandidateLink candidateLink, int candidateId);
	Result addAll(List<CandidateLink> candidateLinks);
	Result addAll(List<CandidateLink> candidateLinks, int candidateId);
	DataResult<List<CandidateLink>> getAll();
	DataResult<CandidateLink> getByCandidateId(int candidateId);
	DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId);
}
