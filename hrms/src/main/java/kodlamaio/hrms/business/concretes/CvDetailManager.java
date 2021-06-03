package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDetailDao;
import kodlamaio.hrms.entities.concretes.CvDetail;

@Service
public class CvDetailManager implements CvDetailService{

	private CvDetailDao cvDetailDao;

	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao) {
		super();
		this.cvDetailDao = cvDetailDao;
	}

	@Override
	public DataResult<List<CvDetail>> getAll() {
		return new SuccessDataResult<List<CvDetail>>(this.cvDetailDao.findAll(),"Tüm cv bilgileri getirildi");
	}

	@Override
	public Result add(CvDetail cvDetail) {
		this.cvDetailDao.save(cvDetail);
		return new SuccessResult("Cv eklendi");
	}
	
	
	
}
