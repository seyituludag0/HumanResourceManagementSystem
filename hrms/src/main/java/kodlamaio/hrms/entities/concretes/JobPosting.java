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
@Table(name="job_postings")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "job_details")
    private String jobDetails;


    @Column(name = "min_wage")
    private double minWage;


    @Column(name = "max_wage")
    private double maxWage;


    @Column(name = "number_of_open_position")
    private int numberOfOpenPositions;


    @Column(name = "last_apply_date")
    private LocalDate lastApplyDate;


    @Column(name = "is_active")
    private boolean isActive;
    
    
    @Column(name = "release_status")
    private boolean releaseStatus;

    
    @Column(name = "posted_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date postedDate;



	@ManyToOne()
	@JoinColumn(name = "employer_id")
    private Employer employer;


	@ManyToOne()
	@JoinColumn(name = "job_id")
	private JobTitle jobTitle;
	


    @ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

    @ManyToOne()
    @JoinColumn(name="work_type_id")
    private WorkType workType;
    
    @ManyToOne()
    @JoinColumn(name="work_time_id")
    private WorkingTime workingTimes;
    
    
    public JobPosting(String jobDetails, double minWage, double maxWage, int numberOfOpenPositions, LocalDate lastApplyDate,
			boolean isActive, Date postedDate) {
		super();
		this.jobDetails = jobDetails;
		this.minWage = minWage;
		this.maxWage = maxWage;
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.lastApplyDate = lastApplyDate;
		this.isActive = isActive;
		this.postedDate = postedDate;
	}
    
    
}