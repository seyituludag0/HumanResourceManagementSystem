package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public Result add(Employer employer) {



    	if(!isRealEmail(employer)){
            return new ErrorDataResult<Employer>(null, Message.checkYourEmail);
        }
        else if(employerDao.findByEmail(employer.getEmail()).stream().count()!=0){
            return new ErrorDataResult<Employer>(null,Message.emailAlreadyRegistered);
        }
        this.employerDao.save(employer);
        return new SuccessResult(Message.addEmployer);
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        List<Employer> employers = this.employerDao.findAll();
        return new SuccessDataResult<List<Employer>>(employers, Message.getAllEmployer);
    }

    
    private boolean isRealEmail(Employer employer) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employer.getEmail());
        if(!matcher.matches()) {
            return false;
        }
        return true;
    }

	@Override
	public Result isCompanyEmailExist(String email) {
		if (employerDao.findByEmailContaining(email).isEmpty()) {
			return new SuccessResult();

		} else {
			return new ErrorResult("Bu mail ile kayıtlı şirket var.");
		}
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id), "İş veren getirildi");
	}

   	
}