package kodlamaio.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobPostingDto {
	private int id;

	private String companyName;

    private String jobTitle;

    private int numberOfOpenPositions;

    private Date postedDate;

    private LocalDate lastApplyDate;
	
	
}
