package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface EmployerService {
	Result add(Employer employer);

	Result update(Employer employer);

	DataResult<List<Employer>> getAll();

	DataResult<Employer> getById(int id);

	Result isCompanyEmailExist(String email);

	Result statusChangeConfirmedByEmployee(int employerId);

	long countById(int id);

	long countGetAll();
	
	Result uploadPhoto(int employerId, MultipartFile file);
}
