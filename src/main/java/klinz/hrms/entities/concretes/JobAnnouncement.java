package klinz.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_announcements")
@Entity
public class JobAnnouncement {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@NotNull
	@Column(name="open_positions")
	private int openPositions;
	
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@ManyToOne
    @JoinColumn(name="employer_id")
	@JsonIgnoreProperties({"email", "password", "website", "phoneNumber", "active"})
    private Employer employer;

    @ManyToOne
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
}
