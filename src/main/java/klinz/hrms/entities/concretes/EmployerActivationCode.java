package klinz.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="activation_code_for_employers")
@PrimaryKeyJoinColumn(name = "activation_code_id")
public class EmployerActivationCode extends ActivationCode {
	//Will be used later...
	
	@Column(name="is_confirmed_by_employee")
	private boolean isConfirmedByEmployee;
	
}
