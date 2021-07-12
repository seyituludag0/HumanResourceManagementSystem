package kodlamaio.hrms.business.concretes;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.emailSender.spring.EmailSenderService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	private ActivationCodeDao activationCodeDao;

	@Autowired
	EmailSenderService emailSenderService;

	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public Result verify(String code) {

		ActivationCode activationCode = this.activationCodeDao.findByCode(code);
		activationCode.setVerified(true);
		this.activationCodeDao.save(activationCode);
		System.out.println("Hesabınız doğrulandı");
//		AccountVerified();
		return new SuccessResult(Message.verifiedActivationCode);
	}

//	private void AccountVerified() {
//			emailSenderService.sendSimpleEmail("bnfcgs2@gmail.com", "Hesabınız doğrulandı", "HRMS - Human Resources Manager System | BİLGİLENDİRME");
//	}
	
	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("Doğrulama bağlantısı " + email + " email adresine gönderildi");
		System.out.println("Hesabınızı doğrulamak için lütfen bağlantıya tıklayın: " + verificationLink);
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		return verificationCode;
	}

	@Override
	public Result save(ActivationCode activationCode) {
		this.activationCodeDao.save(activationCode);
		return new SuccessResult();
	}

}
