package klinz.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateDescription;
import klinz.hrms.entities.concretes.CandidateEducation;
import klinz.hrms.entities.concretes.CandidateExperience;
import klinz.hrms.entities.concretes.CandidateImage;
import klinz.hrms.entities.concretes.CandidateKnowledge;
import klinz.hrms.entities.concretes.CandidateLanguage;
import klinz.hrms.entities.concretes.CandidateLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {
	
	@JsonIgnore
    private Candidate candidate;
	private @Valid CandidateImage candidateImage;
	private List<@Valid CandidateLink> candidateLinks;
	private @Valid CandidateDescription candidateDescription;
	private List<@Valid CandidateLanguage> candidateLanguages;
    private List<@Valid CandidateEducation> candidateEducations;
    private List<@Valid CandidateKnowledge> candidateKnowledges;
    private List<@Valid CandidateExperience> candidateExperiences;
    
}
