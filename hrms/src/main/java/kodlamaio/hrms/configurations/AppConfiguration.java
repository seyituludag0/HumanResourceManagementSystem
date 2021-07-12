package kodlamaio.hrms.configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hrms-project",
                "api_key", "994322474216427",
                "api_secret", "_SufDKuLM2Q-4pnZd3KXOATYylE"));
    }
	
	
	
}