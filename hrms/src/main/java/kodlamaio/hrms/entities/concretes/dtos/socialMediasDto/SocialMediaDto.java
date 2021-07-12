package kodlamaio.hrms.entities.concretes.dtos.socialMediasDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SocialMediaDto {
	private int id;
	private String link;
	private int candidateId;
	private int linkTypeId;
}
