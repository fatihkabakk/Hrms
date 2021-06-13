package klinz.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_educations")
@Entity
public class CandidateEducation {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	
	@NotBlank
	@Column(name="department_name")
	private String departmentName;
	
	@NotNull
	@Column(name="start_year")
	private short startYear;
	
	@Column(name="graduate_year")
	private short graduateYear;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
