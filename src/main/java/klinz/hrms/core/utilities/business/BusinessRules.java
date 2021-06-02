package klinz.hrms.core.utilities.business;

import klinz.hrms.core.utilities.results.Result;

public class BusinessRules {
	public static Result Run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess())
                return logic;
        }
        return null;
    }
}
