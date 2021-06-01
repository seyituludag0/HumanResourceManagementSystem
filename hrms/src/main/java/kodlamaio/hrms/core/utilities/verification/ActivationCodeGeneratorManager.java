package kodlamaio.hrms.core.utilities.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ActivationCodeGeneratorManager implements ActivationCodeGeneratorService{

	@Override
	public String verificationLink(String email) {
		UUID code=UUID.randomUUID();

		String link="https://hrmsverification/" +code.toString();

		System.out.println("Doğrulama maili "+ email +" adresinize gönderildi."
				+ "Linke tıklayarak hesabınızı aktif hale getirebilirsiniz "+ link);

		return link;
	}

	@Override
	public String verificationCode() {
		UUID code=UUID.randomUUID();
		String verifyCode=code.toString();
		System.out.println("Aktivasyonuz kodunuz "+ verifyCode);
		return verifyCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public String verificationLink(String email) {
//		UUID code=UUID.randomUUID();
//		
//		String link="https://hrmsverification/"+code.toString();
//		
//		System.out.println("Doğrulama maili "+ email +" adresinize gönderildi."
//				+ "Linke tıklayarak hesabınızı aktif edebilirsiniz"+ link);
//		
//		return link;
//	}
//
//	@Override
//	public String verificationCode() {
//		UUID code=UUID.randomUUID();
//		String verifyCode=code.toString();
//		System.out.println("Aktivasyonuz kodunuz "+ verifyCode);
//		return verifyCode;
//	}
	
}
