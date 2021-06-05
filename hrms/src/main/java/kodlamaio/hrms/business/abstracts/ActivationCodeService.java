package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface ActivationCodeService {
	Result sendActivationCode(int userId);
	Result verify(String code);
}
