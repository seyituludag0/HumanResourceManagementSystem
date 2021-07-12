package kodlamaio.hrms.entities.concretes.dtos.candidateSchoolsDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchoolCandidateDto {

	private int id;
	private int candidateId;
	private int departmentId;
	private LocalDate dateOfEntry;
	private LocalDate dateOfGraduation;
	
}
