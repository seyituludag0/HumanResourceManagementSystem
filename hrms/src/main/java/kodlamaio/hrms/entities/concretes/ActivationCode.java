package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@Table(name = "activation_codes")
public class ActivationCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_verified")
	private boolean isVerified;
	
	@Column(name = "verified_date")
	private LocalDateTime verifiedDate;

	public ActivationCode(int userId, String code, boolean isVerified, LocalDateTime verifiedDate) {
		this.userId = userId;
		this.code = code;
		this.isVerified = isVerified;
		this.verifiedDate = verifiedDate;
	}
}
