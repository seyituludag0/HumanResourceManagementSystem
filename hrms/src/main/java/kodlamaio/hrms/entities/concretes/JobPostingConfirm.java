package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_postings_confirms")
public class JobPostingConfirm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	 @OneToOne(optional = false, fetch = FetchType.LAZY)
	 @JsonBackReference
	 @JoinColumn(name = "job_posting_id")
	 private JobPosting jobPosting;
	
	  @ManyToOne
	  @JoinColumn(name = "employee_id")
	  private Employee employee;
	
	@Column(name="confirmed")
	private boolean confirmed;
	
	
//	@Column(name="confirmed_date")
//    private LocalDate confirmedDate;
	
}
