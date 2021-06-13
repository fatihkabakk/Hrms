package klinz.hrms.core.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import klinz.hrms.core.utilities.results.DataResult;

public interface ImageService {
	@SuppressWarnings("rawtypes")
	DataResult<Map> save(MultipartFile file);
}
