package klinz.hrms.business.abstracts;

import java.util.List;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	Result activateUser(int userId);
}
