package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolCandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;
import kodlamaio.hrms.entities.concretes.dtos.candidateSchoolsDto.SchoolCandidateDto;

@Service
public class SchoolCandidateManager implements SchoolCandidateService {

	private SchoolCandidateDao schoolCandidateDao;
	private SchoolDepartmentDao schoolDepartmentDao;
	private CandidateDao candidateDao;

	@Autowired
	public SchoolCandidateManager(SchoolCandidateDao schoolCandidateDao, SchoolDepartmentDao schoolDepartmentDao, CandidateDao candidateDao) {
		super();
		this.schoolCandidateDao = schoolCandidateDao;
		this.schoolDepartmentDao = schoolDepartmentDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<SchoolCandidate>> getAll() {
		return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.findAll(),
				"Adayın okulları ve bölümleri getirildi");
	}

	@Override
	public Result add(SchoolCandidateDto schoolCandidateDto) {

		SchoolCandidate schoolCandidate = new SchoolCandidate();
		schoolCandidate.setCandidate(this.candidateDao.findById(schoolCandidateDto.getCandidateId()));
		
		schoolCandidate.setSchoolDepartment(this.schoolDepartmentDao.findById(schoolCandidateDto.getDepartmentId()));
		
		schoolCandidate.setDateOfEntry(schoolCandidateDto.getDateOfEntry());
		schoolCandidate.setDateOfGraduation(schoolCandidateDto.getDateOfGraduation());
	
		this.schoolCandidateDao.save(schoolCandidate);
		
		return new SuccessResult("Okul bilgileri eklendi");
	}

	@Override
	public DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SchoolCandidate>>(this.schoolCandidateDao.getByCandidateId(candidateId),
				"Adayın okul listesi getirildi");
	}

	@Override
	public DataResult<List<SchoolCandidate>> getByCandidate_IdOrderByDateOfGraduationDesc(int candidateId) {
		return new SuccessDataResult<List<SchoolCandidate>>(
				this.schoolCandidateDao.getByCandidate_IdOrderByDateOfGraduationDesc(candidateId));
	}

	@Override
	public Result update(SchoolCandidateDto schoolCandidateDto) {
		SchoolCandidate schoolCandidate = new SchoolCandidate();
		
		schoolCandidate.setId(schoolCandidateDto.getId());
		
		schoolCandidate.setCandidate(this.candidateDao.findById(schoolCandidateDto.getCandidateId()));
		
		schoolCandidate.setSchoolDepartment(this.schoolDepartmentDao.findById(schoolCandidateDto.getDepartmentId()));
		
		schoolCandidate.setDateOfEntry(schoolCandidateDto.getDateOfEntry());
		schoolCandidate.setDateOfGraduation(schoolCandidateDto.getDateOfGraduation());
	
		this.schoolCandidateDao.save(schoolCandidate);
		
		return new SuccessResult("Okul bilgileri güncellendi");
	}
	@Override
	public Result delete(int id) {
		this.schoolCandidateDao.deleteById(id);
		return new SuccessResult("Silindi");
	}
}
