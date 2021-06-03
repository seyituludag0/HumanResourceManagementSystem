package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvDetail;

public interface CvDetailService {

	DataResult<List<CvDetail>> getAll();
	DataResult<CvDetail> getByCandidateId(int candidateId);
	Result add(CvDetail cvDetail);
	
}