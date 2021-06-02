package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Workplace;

public interface WorkplaceService {

	DataResult<List<Workplace>> getAll();
	Result add(Workplace workplace);
	
}
