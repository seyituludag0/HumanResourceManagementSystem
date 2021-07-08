package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.helpers.imageHelpers.ImageUpload;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.CvDetail;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private ImageUpload imageUpload;

    @Autowired
    public EmployerManager(EmployerDao employerDao, ImageUpload imageUpload) {
        this.employerDao = employerDao;
        this.imageUpload = imageUpload;
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
    
    public Result uploadPhoto(int employerId, MultipartFile file) {
    	Employer employer = this.getById(employerId).getData();
		System.out.println("id: " + employerId);
		
		
		Map<String, String> result = (Map<String, String>)this.imageUpload.upload(file).getData();
		String url = result.get("url");
		employer.setCompanyLogo(url);
		
		this.employerDao.save(employer);
		
		return new SuccessResult("Resim eklendi");
	}
    
    @Override
    public Result update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Güncellendi");
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
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id), "İş veren getirildi");
	}

	@Override
	public Result statusChangeConfirmedByEmployee(int employerId) {
		Employer employer = this.employerDao.findById(employerId);
		employer.setVerified(!employer.isVerified());
		this.employerDao.save(employer);
		return new SuccessResult("Şirketin Doğrulanma durumu değiştirildi");
	}

	@Override
	public long countById(int id) {
		return this.employerDao.countById(id);
	}

	@Override
	public long countGetAll() {
		return this.employerDao.count();
	}

   	
}
