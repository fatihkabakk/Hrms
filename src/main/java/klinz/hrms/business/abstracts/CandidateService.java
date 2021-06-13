package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.dtos.CandidateForRegisterDto;

public interface CandidateService {
	Result add(CandidateForRegisterDto candidateForRegisterDto);
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int candidateId);
	DataResult<Candidate> getByEmail(String email);
}
