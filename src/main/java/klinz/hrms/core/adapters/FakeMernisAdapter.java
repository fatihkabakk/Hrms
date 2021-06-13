package klinz.hrms.core.adapters;

import org.springframework.stereotype.Service;

import klinz.hrms.core.abstracts.PersonCheckService;
import klinz.hrms.entities.concretes.Candidate;

@Service("fakeMernisAdapter")
public class FakeMernisAdapter implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		if (candidate.getIdentityNumber().length() == 11) {
			return true;
		}
		return false;
		
	}

}
