package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		List<Employee> employees = this.employeeDao.findAll();
		if(employees.isEmpty()) {
			return new ErrorDataResult<>(Message.getNullEmployee);
		}
		return new SuccessDataResult<List<Employee>>(employees, Message.getAllEmployee);
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
	    return new SuccessResult(Message.addEmployee);
	}

	@Override
	public Result update(Employee employee) {
		employeeDao.save(employee);
	    return new SuccessResult(Message.updateEmployee);
	}

	@Override
	public Result delete(int id) {
		employeeDao.deleteById(id);
		return new SuccessResult(Message.deleteEmployee);
	}

	

	

//	@Override
//	public Result isEmployeeEmailExist(String email) {
//		if (employeeDao.findByEmailContaining(email).isEmpty()) {
//			return new SuccessResult();
//
//		} else {
//			return new ErrorResult("Bu mail ile kayıtlı kullanıcı var.");
//		}
//	}

	

	

	
}
