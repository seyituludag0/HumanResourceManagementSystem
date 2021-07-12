package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService{

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
    	List<User> users = this.userDao.findAll();
    	if(users.isEmpty()) {
    		return new ErrorDataResult<>(Message.getNullUser);
    	}
    	return new SuccessDataResult<List<User>>(users, Message.getAllUser);
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Listelendi");
    }
}
