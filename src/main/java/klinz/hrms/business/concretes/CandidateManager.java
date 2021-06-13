package klinz.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateService;
import klinz.hrms.core.abstracts.MailService;
import klinz.hrms.core.abstracts.PersonCheckService;
import klinz.hrms.core.utilities.business.BusinessRules;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.dtos.CandidateForRegisterDto;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private PersonCheckService personCheckService;
	private MailService mailService;
	private ModelMapper modelMapper;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, @Qualifier("fakeMernisAdapter") PersonCheckService personCheckService, MailService mailService, ModelMapper modelMapper) {
		super();
		this.candidateDao = candidateDao;
		this.personCheckService = personCheckService;
		this.mailService = mailService;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CandidateForRegisterDto candidateForRegisterDto) {
		Candidate candidate = this.modelMapper.map(candidateForRegisterDto, Candidate.class);
		
		var result = BusinessRules.Run(checkIfNull(candidateForRegisterDto), checkIfUniqueIdentity(candidate.getIdentityNumber()), 
				checkIfUniqueEmail(candidate.getEmail()), checkIfPasswordsMatch(candidateForRegisterDto));
		
		if (result != null) {
			return result;
		}
		
		if (this.personCheckService.checkIfRealPerson(candidate)) {
			this.mailService.sendMail(candidate.getEmail(), "Fake Activation (Temp)");
			this.candidateDao.save(candidate);
			return new SuccessResult("User is saved");
		}
		return new ErrorResult("Couldn't validate user identity");
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");
	}
	

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId), "Candidate listed");
	}
	
	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email), "Candidate listed");	
	}
	
	private Result checkIfPasswordsMatch(CandidateForRegisterDto candidateForRegisterDto) {
		if (candidateForRegisterDto.getPassword().equals(candidateForRegisterDto.getPasswordConfirm())) {
			return new SuccessResult("Passwords match");
		}
		return new ErrorResult("Passwords doesn't match");
		
	}
	
	private Result checkIfUniqueIdentity(String identityNumber) {
		var result = this.candidateDao.getByIdentityNumber(identityNumber);
		if (result != null) {
			return new ErrorResult("Identity number already exists");
		}
		return new SuccessResult("Identity number is unique");
	}
	
	private Result checkIfUniqueEmail(String email) {
		var result = this.candidateDao.getByEmail(email);
		if (result != null) {
			return new ErrorResult("Email already exists");
		}
		return new SuccessResult("Email is unique");
	}
	
	private Result checkIfNull(CandidateForRegisterDto candidateForRegisterDto) {
		if (candidateForRegisterDto.getFirstName().isBlank() || candidateForRegisterDto.getLastName().isBlank() ||
				candidateForRegisterDto.getIdentityNumber().isBlank() || candidateForRegisterDto.getBirthYear() == null ||
				candidateForRegisterDto.getEmail().isBlank() || candidateForRegisterDto.getPassword().isBlank() || 
				candidateForRegisterDto.getPasswordConfirm().isBlank()) {
			return new ErrorResult("Please fill the blank area(s)");
		}
		return new SuccessResult("Validation successfull");
	}

}
