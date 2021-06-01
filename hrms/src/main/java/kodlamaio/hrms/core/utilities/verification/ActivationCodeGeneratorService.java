package kodlamaio.hrms.core.utilities.verification;

public interface ActivationCodeGeneratorService {
	String verificationLink(String email);
	String verificationCode();
}
