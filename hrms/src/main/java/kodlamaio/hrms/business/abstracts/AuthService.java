package kodlamaio.hrms.business.abstracts;
import javax.mail.MessagingException;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

public interface AuthService {
	Result registerCandidate(Candidate candidate) throws MessagingException;
	Result registerEmployer(Employer employer) throws MessagingException;
}
