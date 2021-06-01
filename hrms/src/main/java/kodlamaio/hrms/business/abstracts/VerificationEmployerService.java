package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationEmployer;

public interface VerificationEmployerService {
	Result add(VerificationEmployer employer);
}
