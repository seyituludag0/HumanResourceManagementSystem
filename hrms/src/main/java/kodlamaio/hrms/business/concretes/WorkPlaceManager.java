package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkplaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.hrms.entities.concretes.WorkPlace;

@Service
public class WorkPlaceManager implements WorkplaceService{

	private WorkPlaceDao workplaceDao;
	
	@Autowired
	public WorkPlaceManager(WorkPlaceDao workplaceDao) {
		super();
		this.workplaceDao = workplaceDao;
	}

	@Override
	public DataResult<List<WorkPlace>> getAll() {
		return new SuccessDataResult<List<WorkPlace>>(this.workplaceDao.findAll(),"Tüm işyerleri listelendi");
	}

	@Override
	public Result add(WorkPlace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult("İşyeri eklendi");
	}
	
	@Override
	public Result update(WorkPlace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult("Güncellendi");
	}
}
