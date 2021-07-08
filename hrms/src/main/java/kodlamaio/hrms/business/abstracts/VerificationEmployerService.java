package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationEmployer;

public interface VerificationEmployerService {

	DataResult<List<VerificationEmployer>> getAll();
	
	DataResult<VerificationEmployer> getById(int id);
	
	DataResult<List<VerificationEmployer>> getAllByVerifyFalse();
	
	Result add(VerificationEmployer verificationEmployer);
	
	Result update(VerificationEmployer verificationEmployer);
	
	Result delete(int id);
	
}
