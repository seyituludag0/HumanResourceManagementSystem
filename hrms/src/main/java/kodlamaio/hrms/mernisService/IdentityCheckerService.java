package kodlamaio.hrms.mernisService;

public interface IdentityCheckerService {
	boolean fakeMernisControl(String firstName, String lastName, String identityNumber, String birthYear);
}