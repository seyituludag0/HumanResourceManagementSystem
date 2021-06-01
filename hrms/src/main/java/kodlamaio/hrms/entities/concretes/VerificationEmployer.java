package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_employers")
public class VerificationEmployer  extends ActivationCode{

	@Column(name = "employer_id")
	private int employerId;
	
	public VerificationEmployer(int id, String activationCode, boolean isValid, int employerId) {
		super(id, activationCode, isValid);
		this.employerId = employerId;
	}
}
