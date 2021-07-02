package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name="candidates")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "schoolCandidates" })
public class Candidate extends User{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Pattern(regexp="^[1-9]{1}[0-9]{9}[02468]{1}$",message="TC No format hatası")
	@Column(name="identity_number")
	private String identityNumber;
	
	
	@Column(name="birth_date")
	private LocalDate birthDate;	
	
	
	@OneToMany(mappedBy = "candidate")
	private List<SchoolCandidate> schoolCandidates;
	
}
