package kodlamaio.hrms.mernisService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IdentityCheckerService {
	boolean fakeMernisControl(String firstName, String lastName, String identityNumber, LocalDate birthYear);
}