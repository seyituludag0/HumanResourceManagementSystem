  
package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="job_posting")
public class JobPosting {


//  @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//  @JsonIgnore
    @Column(name = "job_details")
    private String jobDetails;

//  @JsonIgnore
    @Column(name = "min_wage")
    private double minWage;

//  @JsonIgnore
    @Column(name = "max_wage")
    private double maxWage;

//  @JsonIgnore
    @Column(name = "number_of_open_position")
    private int numberOfOpenPositions;

//  @JsonIgnore
    @Column(name = "last_apply_date")
    private LocalDate lastApplyDate;

//  @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive;


//  @JsonIgnore
    @Column(name = "posted_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date postedDate;


//    @JsonIgnore
    @ManyToOne()
	@JoinColumn(name = "employer_id")
    private Employer employer;

//    @JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private JobTitle jobTitle;
	

//    @JsonIgnore
    @ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

}
