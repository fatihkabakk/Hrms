package klinz.hrms.business.concretes;

import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.MailService;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessResult;

@Service
public class FakeMailManager implements MailService {

	@Override
	public Result sendActivationCode(String email) {
		//Fake service
		return new SuccessResult("Email sent");
	}

}
