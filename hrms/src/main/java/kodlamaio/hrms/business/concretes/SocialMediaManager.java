package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.internal.constraintvalidators.hv.URLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService{

	private SocialMediaDao socialMediaDao;

	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}
	


	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.findAll(), "Sosyal medyalar getirildi");
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		
		this.socialMediaDao.save(socialMedia);	
		return new SuccessResult("Sosyal medya eklendi");
	}
	

	@Override
	public DataResult<List<SocialMedia>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.getByCandidate_Id(candidateId), "Adayın sosyal medya hesapları getirildi");
	}
	
}
