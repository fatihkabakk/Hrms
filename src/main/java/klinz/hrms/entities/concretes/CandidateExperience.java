package klinz.hrms.entities.concretes;

import java.time.LocalDate;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_experiences")
@Entity
public class CandidateExperience {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@Column(name="position")
	private String position;
	
	@NotBlank
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="leave_date")
	private LocalDate leaveDate;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
