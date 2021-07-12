package kodlamaio.hrms.entities.concretes.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFilterDto {
	
	private String searchText;
	private List<Integer> workTypeId;
	private List<Integer> jobTitleId;
	private List<Integer> cityId;
	
//	private String searchText;
//	private int workTypeId;
//	private int jobTitleId;
//	private int cityId;
}
