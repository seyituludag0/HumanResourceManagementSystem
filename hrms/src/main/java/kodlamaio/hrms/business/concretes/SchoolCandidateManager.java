package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolCandidateDao;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;

@Service
public class SchoolCandidateManager implements SchoolCandidateService {

	private SchoolCandidateDao schoolCandidateDao;

	@Autowired
	public SchoolCandidateManager(SchoolCandidateDao schoolCandidateDao) {
		super();
		this.schoolCandidateDao = schoolCandidateDao;
	}

	@Override
	public DataResult<List<SchoolCandidate>> getAll() {
		return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.findAll(),
				"Adayın okulları ve bölümleri getirildi");
	}

	@Override
	public Result add(SchoolCandidate schoolCandidate) {
		this.schoolCandidateDao.save(schoolCandidate);
		return new SuccessResult("Okul departmanı eklendi");
	}

	@Override
	public DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SchoolCandidate>>(this.schoolCandidateDao.getByCandidateId(candidateId),"Adayın okul listesi getirildi");
	}

}
