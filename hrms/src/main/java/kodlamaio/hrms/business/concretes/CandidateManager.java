package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.adapters.EmailAdapter;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityCandidateService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageCandidateService;
import kodlamaio.hrms.business.abstracts.SchoolCandidateService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.business.abstracts.WorkPlaceCandidateService;
import kodlamaio.hrms.business.constants.Message;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.dtos.CvDto;
import kodlamaio.hrms.mernisService.IdentityCheckerService;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private IdentityCheckerService identityCheckerService;
	private EmailAdapter emailAdapter;

	private SchoolCandidateService schoolCandidateService;
	private LanguageCandidateService languageCandidateService;
	private WorkPlaceCandidateService workPlaceCandidateService;
	private SocialMediaService socialMediaService;
	private AbilityCandidateService abilityCandidateService;
//	private ExperienceDao experienceDao;
	private ExperienceService experienceService;
	private CvDetailService cvDetailService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailAdapter emailAdapter,
			IdentityCheckerService identityCheckerService, SchoolCandidateService schoolCandidateService,
			LanguageCandidateService languageCandidateService, WorkPlaceCandidateService workPlaceCandidateService,
			SocialMediaService socialMediaService, AbilityCandidateService abilityCandidateService, ExperienceService experienceService,
			CvDetailService cvDetailService) {
		this.candidateDao = candidateDao;
		this.workPlaceCandidateService = workPlaceCandidateService;
		this.socialMediaService = socialMediaService;
		this.schoolCandidateService = schoolCandidateService;
		this.languageCandidateService = languageCandidateService;
		this.abilityCandidateService = abilityCandidateService;
		this.cvDetailService = cvDetailService;
		this.experienceService = experienceService;
		this.identityCheckerService = identityCheckerService;
		this.emailAdapter = emailAdapter;
		}

	@Override
	public DataResult<CvDto> getCandidateCvByCandidateId(int candidateId) {

		CvDto cvDto = new CvDto();

		cvDto.setCandidate(this.candidateDao.findById(candidateId));
//		cvDto.setCandidate(this.candidateDao.getOne(candidateId));
		cvDto.setWorkPlaceCandidate(this.workPlaceCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setSocialMedias(this.socialMediaService.getByCandidateId(candidateId).getData());
		cvDto.setSchoolCandidates(this.schoolCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setLanguageCandidates(this.languageCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setAbilityCandidates(this.abilityCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setAbilityCandidates(this.abilityCandidateService.getByCandidateId(candidateId).getData());
		
		cvDto.setExperiences(this.experienceService.getByCandidateId(candidateId).getData());
		
		cvDto.setCvDetail(this.cvDetailService.getByCandidateId(candidateId).getData());

		return new SuccessDataResult<CvDto>(cvDto, "Cv getirildi");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		List<Candidate> candidates = this.candidateDao.findAll();
		if (candidates.isEmpty()) {
			return new ErrorDataResult<>(Message.getNullCandidate);
		}
		return new SuccessDataResult<List<Candidate>>(candidates, Message.getAllCandidate);
	}

	@Override
	public Result add(Candidate candidate) {
		if (!identityCheckerService.fakeMernisControl(candidate.getFirstName(), candidate.getLastName(),
				candidate.getIdentityNumber(), candidate.getBirthDate())) {
			return new ErrorResult("Kimlik doğrulanamadı");
		} else if (isMailExists(candidate.getEmail())) {
			return new ErrorResult(Message.emailAlreadyRegistered);
		} else if (isIdentityNumberExists(candidate.getIdentityNumber())) {
			return new ErrorResult(Message.identityNumberAlreadyRegistered);
		} else if (!emailAdapter.sendEmail(candidate.getEmail())) {
			return new ErrorResult("E mail doğrulanmadı");
		}
		candidateDao.save(candidate);
		return new SuccessResult(Message.registered);
	}

	@Override
	public Result update(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult(Message.updateCandidate);
	}

	@Override
	public Result delete(int id) {
		candidateDao.deleteById(id);
		return new SuccessResult(Message.deleteCandidate);
	}

	private boolean isIdentityNumberExists(String identityNumber) {
		return this.candidateDao.findByIdentityNumber(identityNumber).isPresent();
	}

	private boolean isMailExists(String eMail) {
		return this.candidateDao.findByEmail(eMail).isPresent();
	}

	@Override
	public Result isIdentityNumberExist(String identityNumber) {
		if (candidateDao.findByIdentityNumberContaining(identityNumber).isEmpty()) {
			return new SuccessResult();

		} else {
			return new ErrorResult("Bu Tc kimlik no ile kayıtlı kullanıcı var.");
		}
	}


	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getOne(id));
	}

	

	

}