package kodlamaio.hrms.entities.concretes.dtos.languageCandidateDto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LanguageCandidateDto {

	private int id;
	private int languageId;
	private int languageLevelId;
	private int candidateId;
	
}
