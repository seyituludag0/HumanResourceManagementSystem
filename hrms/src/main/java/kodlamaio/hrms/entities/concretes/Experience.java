package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="experiences")
@AllArgsConstructor
@NoArgsConstructor

public class Experience {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "company_name")
	    @NotNull
	    @NotBlank
	    private String companyName;

	    @Column(name = "position")
	    @NotNull
	    @NotBlank
	    private String position;

	    @Column(name = "start_date")
	    @NotNull
	    private LocalDate startDate;

	    @Column(name = "leave_date")
	    private LocalDate leaveDate;

	    @ManyToOne()
	    @JoinColumn(name = "candidate_id")
	    private Candidate candidate;
	
}
