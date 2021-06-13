package klinz.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_images")
@Entity
public class CandidateImage {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="url")
    private String url;
    
    @Column(name="uploaded_date")
    private LocalDateTime uploadedDate;
    
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="candidate_id", referencedColumnName="candidate_id")
    private Candidate candidate;
}
