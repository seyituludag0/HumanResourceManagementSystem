package kodlamaio.hrms.mernisService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


@Service
public  class  IdentityChecker implements IdentityCheckerService {
	
	private FakeMernis fakeMernis;
	
	public IdentityChecker(FakeMernis fakeMernis) {
		this.fakeMernis = fakeMernis;
	}

	
	@Override
	public boolean fakeMernisControl(String firstName, String lastName, String identityNumber, LocalDate birthYear) {

		if (fakeMernis.fakeMernisControl(firstName, lastName, identityNumber, birthYear)) 
		{			
			return true;
		}
		
		return false;
	}
}
