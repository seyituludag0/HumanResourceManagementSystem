package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	private ActivationCodeDao activationCodeDao;

	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}
	
	@Override
	public Result sendActivationCode(int userId) {
		var code = activationCodeDao.save(new ActivationCode(userId, UUID.randomUUID().toString(), false, LocalDateTime.now()));
		System.out.println(code.getCode());
		return new SuccessResult(Message.sendedActivationCode);
	}


	
	@Override
	public Result verify(String code) {
		
		ActivationCode activationCode = this.activationCodeDao.findByCode(code);
		activationCode.setVerified(true);
		this.activationCodeDao.save(activationCode);		
		return new SuccessResult(Message.verifiedActivationCode);
	}
	
}
