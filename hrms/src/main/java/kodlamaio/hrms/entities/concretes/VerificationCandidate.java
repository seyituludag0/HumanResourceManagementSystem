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
@Table(name="verification_candidates")
public class VerificationCandidate  extends ActivationCode{

	
	@Column(name = "candidate_id")
	private int candidateId;
	
	public VerificationCandidate(int id, String activationCode, boolean isValid,  int candidateId) {
		super(id, activationCode, isValid);
		this.candidateId = candidateId;
	}
	
}
