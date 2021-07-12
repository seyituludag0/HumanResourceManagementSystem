package kodlamaio.hrms.business.abstracts;

//import javax.mail.MessagingException;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
//	Result sendActivationCode(int userId) throws MessagingException;
	Result save(ActivationCode activationCode);
	Result verify(String code);
	
	void sendLink(String email);
	String sendCode();
}
