package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.dtos.socialMediasDto.SocialMediaDto;

public interface SocialMediaService {

	DataResult<List<SocialMedia>> getAll();
	
	DataResult<List<SocialMedia>> getByCandidateId(int candidateId);
	
//	Result add(SocialMedia socialMedia);
	
	Result add(SocialMediaDto socialMediato);
	
//	Result update(SocialMedia socialMedia);
	
	Result update(SocialMediaDto socialMedia);
	
	
}
