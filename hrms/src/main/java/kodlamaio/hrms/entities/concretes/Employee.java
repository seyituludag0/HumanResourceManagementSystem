package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Pattern(regexp="^[1-9]{1}[0-9]{9}[02468]{1}$",message="TC No format hatası")
	@Column(name="identity_number")
	private String identityNumber;
	
	@Size(min = 4, max = 4, message = "Doğum yılı 4 hane olmak zorundadır")
	@Column(name="birth_year")
	private String birthYear;
	
	
}
