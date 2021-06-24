package kodlamaio.hrms.mernisService;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class FakeMernis {
	
	public boolean fakeMernisControl(String firstName, String lastName, String identityNumber, LocalDate birthDate) {
		if(firstName.length()<=3 || lastName.length()<=3 || identityNumber.length()==11 ||  birthDate.isBefore(birthDate)) {

			return true;
		}
		else {
			
			return false;
		}
		
	}
}
