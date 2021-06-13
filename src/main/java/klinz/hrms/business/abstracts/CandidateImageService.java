package klinz.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {
	Result add(CandidateImage candidateImage);
	Result add(MultipartFile file, int candidateId);
	DataResult<List<CandidateImage>> getAll();
	DataResult<CandidateImage> getByCandidateId(int candidateId);
}
