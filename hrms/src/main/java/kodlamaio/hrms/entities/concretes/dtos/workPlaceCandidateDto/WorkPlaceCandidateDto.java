package kodlamaio.hrms.entities.concretes.dtos.workPlaceCandidateDto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkPlaceCandidateDto {

	private int id;
	private int candidateId;
	private String workPlaceName;
	private String jobTitleName;
	private LocalDate dateOfEntry;
	private LocalDate dateOfQuit;
}
