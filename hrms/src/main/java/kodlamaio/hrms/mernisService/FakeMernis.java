package kodlamaio.hrms.mernisService;

import org.springframework.stereotype.Service;

@Service
public class FakeMernis {
	
	public boolean fakeMernisControl(String firstName, String lastName, String identityNumber, String birthYear) {
		if(firstName.length()<=3 || lastName.length()<=3 || identityNumber.length()==11 ||  birthYear.length()==4) {

			return true;
		}
		else {
			
			return false;
		}
		
	}
}
