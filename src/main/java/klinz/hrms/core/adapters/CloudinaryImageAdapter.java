package klinz.hrms.core.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import klinz.hrms.core.abstracts.ImageService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorDataResult;
import klinz.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageAdapter implements ImageService {
	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryImageAdapter(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> save(MultipartFile file) {
		try {
			return new SuccessDataResult<Map>(cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()), "File uploded");
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<Map>("Upload failed");
		}
	}

}
