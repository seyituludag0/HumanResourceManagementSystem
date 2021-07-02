package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.LinkTypeDao;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.dtos.socialMediasDto.SocialMediaDto;

@Service
public class SocialMediaManager implements SocialMediaService{

	private SocialMediaDao socialMediaDao;
	private CandidateDao candidateDao;
	private LinkTypeDao linkTypeDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao, CandidateDao candidateDao, LinkTypeDao linkTypeDao) {
		super();
		this.socialMediaDao = socialMediaDao;
		this.candidateDao = candidateDao;
		this.linkTypeDao = linkTypeDao;
	}

	
	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.findAll(), "Sosyal medyalar getirildi");
	}


	

	@Override
	public DataResult<List<SocialMedia>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.getByCandidate_Id(candidateId), "Adayın sosyal medya hesapları getirildi");
	}



	@Override
	public Result add(SocialMediaDto socialMediaAddDto) {
		
		SocialMedia socialMedia = new SocialMedia();
		
		socialMedia.setCandidate(this.candidateDao.findById(socialMediaAddDto.getCandidateId()));
		socialMedia.setLinkType(this.linkTypeDao.findById(socialMediaAddDto.getLinkTypeId()));
		socialMedia.setLink(socialMediaAddDto.getLink());
		
		this.socialMediaDao.save(socialMedia);
		
		return new SuccessResult("Sosyal medya eklendi");
	}
	
	
	@Override
	public Result update(SocialMediaDto socialMediaDto) {
		
		SocialMedia socialMedia = new SocialMedia();
		socialMedia.setId(socialMediaDto.getId());
		socialMedia.setCandidate(this.candidateDao.findById(socialMediaDto.getCandidateId()));
		socialMedia.setLinkType(this.linkTypeDao.findById(socialMediaDto.getLinkTypeId()));
		socialMedia.setLink(socialMediaDto.getLink());
		
		this.socialMediaDao.save(socialMedia);
		
		return new SuccessResult("Sosyal medya güncellendi");
	}






	






	
	
}
