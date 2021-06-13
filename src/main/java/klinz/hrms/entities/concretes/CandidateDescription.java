package klinz.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_descriptions")
@Entity
public class CandidateDescription {
	@Id
	@Column(name="id")
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="description")
	private String description;
	
	@OneToOne
	@JsonIgnore
    @JoinColumn(name="candidate_id", referencedColumnName="candidate_id")
	private Candidate candidate;
}