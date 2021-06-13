package klinz.hrms.business.abstracts;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.dtos.CvDto;

public interface CvService {
	Result add(CvDto cvDto, int candidateId);
	DataResult<CvDto> getByCandidateId(int candidateId);
}
