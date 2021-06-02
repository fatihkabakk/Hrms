package klinz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.UserService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.UserDao;
import klinz.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users are listed");
	}

	@Override
	public Result activateUser(int userId) {
		User user = this.userDao.getById(userId);
		user.setActive(true);
		this.userDao.save(user);
		return new SuccessResult("User is updated");
	}

}
