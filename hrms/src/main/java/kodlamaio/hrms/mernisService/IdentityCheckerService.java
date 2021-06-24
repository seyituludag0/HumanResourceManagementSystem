package kodlamaio.hrms.mernisService;

import java.time.LocalDate;

public interface IdentityCheckerService {
	boolean fakeMernisControl(String firstName, String lastName, String identityNumber, LocalDate birthYear);
}