package klinz.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import klinz.hrms.core.abstracts.PersonCheckService;
import klinz.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service("mernisAdapter")
public class MernisAdapter implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear().getYear());
		}
		catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
}
