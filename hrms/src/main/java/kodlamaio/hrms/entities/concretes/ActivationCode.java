package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name="activation_codes")
public class ActivationCode {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="is_valid")
	private boolean isValid;
	
//		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//		@Column(name="validation_date", columnDefinition = "Date default CURRENT_DATE")
//		private LocalDate validationDate = LocalDate.now();
	
//	@Column(name="validation_date")
//	private LocalDate validationDate;
}
