package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "verification_employers")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationEmployer {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Pattern(regexp = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$", message = "Telefon numarası format hatası")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
}
