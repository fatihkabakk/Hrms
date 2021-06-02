package klinz.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.EmployerService;
import klinz.hrms.business.abstracts.MailService;
import klinz.hrms.core.utilities.business.BusinessRules;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.EmployerDao;
import klinz.hrms.entities.concretes.Employer;
import klinz.hrms.entities.dtos.EmployerForRegisterDto;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private MailService mailService;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, MailService mailService, ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.mailService = mailService;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(EmployerForRegisterDto employerForRegisterDto) {
		var result = BusinessRules.Run(checkIfUniqueEmail(employerForRegisterDto.getEmail()), checkIfNull(employerForRegisterDto), 
				checkIfPasswordsMatch(employerForRegisterDto), checkIfDomainsMatch(employerForRegisterDto));
		Employer employer = this.modelMapper.map(employerForRegisterDto, Employer.class);
		
		
		
		if (result != null) {
			return result;
		}
		
		this.mailService.sendActivationCode(employer.getEmail());
		this.employerDao.save(employer);
		return new SuccessResult("Employer is saved");
	
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed");
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email), "Employer listed");
	}
	
	private Result checkIfDomainsMatch(EmployerForRegisterDto employerForRegisterDto) {
		var domain = employerForRegisterDto.getEmail().split("@")[1];
		if (employerForRegisterDto.getWebsite().equals(domain)) {
			return new SuccessResult("Domains match");
		}
		return new ErrorResult("Domains don't match");
		
	}
	
	private Result checkIfPasswordsMatch(EmployerForRegisterDto employerForRegisterDto) {
		if (employerForRegisterDto.getPassword().equals(employerForRegisterDto.getPasswordConfirm())) {
			return new SuccessResult("Passwords match");
		}
		return new ErrorResult("Passwords don't match");
		
	}
	
	private Result checkIfUniqueEmail(String email) {
		var result = this.employerDao.getByEmail(email);
		if (result != null) {
			return new ErrorResult("Email already exists");
		}
		return new SuccessResult("Email is unique");
	}
	
	private Result checkIfNull(EmployerForRegisterDto employerForRegisterDto) {
		if (employerForRegisterDto.getCompanyName().isBlank() || employerForRegisterDto.getWebsite().isBlank() || 
				employerForRegisterDto.getEmail().isBlank() || employerForRegisterDto.getPhoneNumber().isBlank() ||
				employerForRegisterDto.getPassword().isBlank() || employerForRegisterDto.getPasswordConfirm().isBlank()) {
			return new ErrorResult("Please fill the blank area(s)");
		}
		return new SuccessResult("Validation successfull");
	}
	
}
