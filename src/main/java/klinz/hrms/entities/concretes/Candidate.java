package klinz.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@Entity
@PrimaryKeyJoinColumn(name = "candidate_id")
public class Candidate extends User {
	
	@Column(name="candidate_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private LocalDate birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateEducation> candidateEducations;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateExperience> candidateExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateLanguage> candidateLanguages;
	
	@JsonIgnore
	@OneToOne(mappedBy="candidate")
	private CandidateImage candidateImage;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateLink> candidateLinks;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateKnowledge> candidateKnowledges;
	
	@JsonIgnore
	@OneToOne(mappedBy="candidate")
	private CandidateDescription candidateDescription;
}
