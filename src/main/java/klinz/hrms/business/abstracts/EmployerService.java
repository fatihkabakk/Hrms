package klinz.hrms.business.abstracts;

import java.util.List;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.Employer;
import klinz.hrms.entities.dtos.EmployerForRegisterDto;

public interface EmployerService {
	Result add(EmployerForRegisterDto employerForRegisterDto);
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getByEmail(String email);
}
