package kodlamaio.hrms.entities.concretes.dtos.experienceDto;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateExperienceDto {

	private int id;
	private int candidateId;
    private String companyName;
    private String position;
    private LocalDate startDate;
    private LocalDate leaveDate;
}
