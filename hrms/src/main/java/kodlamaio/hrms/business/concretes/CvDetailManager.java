package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDetailDao;
import kodlamaio.hrms.entities.concretes.CvDetail;
import kodlamaio.hrms.core.helpers.imageHelpers.ImageUpload;

@Service
public class CvDetailManager implements CvDetailService{

	private CvDetailDao cvDetailDao;
	private ImageUpload imageUpload;

	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao, ImageUpload imageUpload) {
		super();
		this.cvDetailDao = cvDetailDao;
		this.imageUpload = imageUpload;
	}

	@Override
	public DataResult<List<CvDetail>> getAll() {
		return new SuccessDataResult<List<CvDetail>>(this.cvDetailDao.findAll(),"Tüm cv bilgileri getirildi");
	}
	
	@Override
	public DataResult<CvDetail> getByCandidateId(int candidateId){
		return new SuccessDataResult<CvDetail>(this.cvDetailDao.getByCandidate_Id(candidateId),"Adayın cv'si getirildi");
	}

	@Override
	public Result add(CvDetail cvDetail) {
		this.cvDetailDao.save(cvDetail);
		return new SuccessResult("Cv eklendi");
	}

	public Result uploadPhoto(int candidateId, MultipartFile file) {
		CvDetail candidate = this.getByCandidateId(candidateId).getData();
		System.out.println("id: " + candidateId);
		
		
		Map<String, String> result = (Map<String, String>)this.imageUpload.upload(file).getData();
		String url = result.get("url");
		candidate.setCvPhotoUrl(url);
		
		this.cvDetailDao.save(candidate);
		
		return new SuccessResult("Resim eklendi");
	}
	
	
	
}
