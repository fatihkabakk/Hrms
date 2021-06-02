package klinz.hrms.business.abstracts;

import klinz.hrms.core.utilities.results.Result;

public interface MailService {
	Result sendActivationCode(String email);
}
