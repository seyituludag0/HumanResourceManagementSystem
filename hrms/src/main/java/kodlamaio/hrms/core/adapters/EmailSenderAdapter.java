package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.emailVerification.EmailSender;

@Service
public class EmailSenderAdapter implements EmailAdapter{

	@Override
	public boolean sendEmail(String email) {
		EmailSender emailSender = new EmailSender();
        return emailSender.sendEmail(email);
	}

}
