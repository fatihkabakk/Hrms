package klinz.hrms.core.abstracts;

import klinz.hrms.core.utilities.results.Result;

public interface MailService {
	Result sendMail(String email, String message);
}
