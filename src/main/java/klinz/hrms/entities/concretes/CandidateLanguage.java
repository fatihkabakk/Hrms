package klinz.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_languages")
@Entity
public class CandidateLanguage {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Min(1)
	@Max(5)
	@NotNull
	@Column(name="level")
	private byte level;
	
	@ManyToOne
	@JoinColumn(name="language_id", referencedColumnName="id")
	private Language language;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	@JsonIgnore
	private Candidate candidate;
}
