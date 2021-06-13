package klinz.hrms.core.adapters;

import org.springframework.stereotype.Service;

import klinz.hrms.core.abstracts.MailService;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessResult;

@Service
public class FakeMailAdapter implements MailService {

	@Override
	public Result sendMail(String email, String message) {
		return new SuccessResult("Mail Sent");
	}

}
