package kodlamaio.hrms.entities.concretes.dtos;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {

//private int id;
	
	private int employerId;
	
	private int cityId;
	
	private int jobTitleId;
	
    private double minWage;

    private double maxWage;
	

    private int workTypeId;
    
    private int workingTimeId;
    
    private String jobDetails;

    private int numberOfOpenPositions;

    @JsonIgnore
    private Date postedDate;

    private LocalDate lastApplyDate;
    
    private boolean isActive;
    
    
//    private String companyName;
//
//    private String jobTitle;
	
}