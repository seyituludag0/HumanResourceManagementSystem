package kodlamaio.hrms.core.helpers.imageHelpers;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageUpload {
	DataResult<Map> upload(MultipartFile file);
}
