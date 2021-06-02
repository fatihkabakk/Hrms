package klinz.hrms.core.abstracts;

import klinz.hrms.entities.concretes.Candidate;

public interface PersonCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
