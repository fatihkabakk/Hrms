package klinz.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klinz.hrms.business.abstracts.CandidateDescriptionService;
import klinz.hrms.business.abstracts.CandidateEducationService;
import klinz.hrms.business.abstracts.CandidateExperienceService;
import klinz.hrms.business.abstracts.CandidateImageService;
import klinz.hrms.business.abstracts.CandidateKnowledgeService;
import klinz.hrms.business.abstracts.CandidateLanguageService;
import klinz.hrms.business.abstracts.CandidateLinkService;
import klinz.hrms.business.abstracts.CandidateService;
import klinz.hrms.business.abstracts.CvService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {
	
	private CandidateService candidateService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateImageService candidateImageService;
	private CandidateDescriptionService candidateDescriptionService;
	private CandidateEducationService candidateEducationService;
	private CandidateLinkService candidateLinkService;
	private CandidateKnowledgeService candidateKnowledgeService;
	private CandidateLanguageService candidateLanguageService;
	
	@Autowired
	public CvManager(CandidateService candidateService, CandidateExperienceService candidateExperienceService,
			CandidateImageService candidateImageService, CandidateDescriptionService candidateDescriptionService,
			CandidateEducationService candidateEducationService, CandidateLinkService candidateLinkService,
			CandidateKnowledgeService candidateKnowledgeService, CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateService = candidateService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateImageService = candidateImageService;
		this.candidateDescriptionService = candidateDescriptionService;
		this.candidateEducationService = candidateEducationService;
		this.candidateLinkService = candidateLinkService;
		this.candidateKnowledgeService = candidateKnowledgeService;
		this.candidateLanguageService = candidateLanguageService;
	}

	@Override
	public Result add(CvDto cvDto, int candidateId) {
		Candidate candidate = candidateService.getById(candidateId).getData();
		cvDto.setCandidate(candidate);
		
		cvDto.getCandidateEducations().forEach(candidateEducation -> candidateEducation.setCandidate(candidate));
		candidateEducationService.addAll(cvDto.getCandidateEducations());
		
		cvDto.getCandidateExperiences().forEach(candidateExperience -> candidateExperience.setCandidate(candidate));
		candidateExperienceService.addAll(cvDto.getCandidateExperiences());
		
		cvDto.getCandidateLanguages().forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
		candidateLanguageService.addAll(cvDto.getCandidateLanguages());
		
		cvDto.getCandidateImage().setCandidate(candidate);
		candidateImageService.add(cvDto.getCandidateImage());
		
		cvDto.getCandidateLinks().forEach(candidateLink -> candidateLink.setCandidate(candidate));
		candidateLinkService.addAll(cvDto.getCandidateLinks());
		
		cvDto.getCandidateKnowledges().forEach(candidateKnowledge -> candidateKnowledge.setCandidate(candidate));
		candidateKnowledgeService.addAll(cvDto.getCandidateKnowledges());
		
		cvDto.getCandidateDescription().setCandidate(candidate);
		candidateDescriptionService.add(cvDto.getCandidateDescription());
		
		return new SuccessResult("Cv saved");
	}

	@Override
	public DataResult<CvDto> getByCandidateId(int candidateId) {
		CvDto cvDto = new CvDto();
		
		cvDto.setCandidate(this.candidateService.getById(candidateId).getData());
		cvDto.setCandidateDescription(this.candidateDescriptionService.getByCandidateId(candidateId).getData());
		cvDto.setCandidateEducations(this.candidateEducationService.getAllByCandidateIdOrderByLeaveDateDesc(candidateId).getData());
		cvDto.setCandidateExperiences(this.candidateExperienceService.getAllByCandidateIdOrderByLeaveDateDesc(candidateId).getData());
		cvDto.setCandidateImage(this.candidateImageService.getByCandidateId(candidateId).getData());
		cvDto.setCandidateKnowledges(this.candidateKnowledgeService.getAllByCandidateId(candidateId).getData());
		cvDto.setCandidateLanguages(this.candidateLanguageService.getAllByCandidateId(candidateId).getData());
		cvDto.setCandidateLinks(this.candidateLinkService.getAllByCandidateId(candidateId).getData());
		
		return new SuccessDataResult<CvDto>(cvDto, "Candidate's Cv listed");
		
	}

}
