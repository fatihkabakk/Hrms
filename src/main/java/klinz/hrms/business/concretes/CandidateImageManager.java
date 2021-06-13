package klinz.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import klinz.hrms.business.abstracts.CandidateImageService;
import klinz.hrms.core.abstracts.ImageService;
import klinz.hrms.core.utilities.results.DataResult;
import klinz.hrms.core.utilities.results.ErrorResult;
import klinz.hrms.core.utilities.results.Result;
import klinz.hrms.core.utilities.results.SuccessDataResult;
import klinz.hrms.core.utilities.results.SuccessResult;
import klinz.hrms.dataAccess.abstracts.CandidateImageDao;
import klinz.hrms.entities.concretes.Candidate;
import klinz.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManager implements CandidateImageService {

	private CandidateImageDao candidateImageDao;
	private ImageService imageService;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao, ImageService imageService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Candidate Image saved");
	}
	
	@Override
	public Result add(MultipartFile file, int candidateId) {
		var result = this.imageService.save(file);
		if (!result.isSuccess()) {
			return new ErrorResult("Failed to save image");
		}
		
		Candidate candidate = new Candidate();
		CandidateImage candidateImage = new CandidateImage();
		candidate.setId(candidateId);
		candidateImage.setUrl((String) result.getData().get("url"));
		candidateImage.setUploadedDate(LocalDateTime.now());
		candidateImage.setCandidate(candidate);
		
		return this.add(candidateImage);
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll(), "Candidate Images listed");
	}

	@Override
	public DataResult<CandidateImage> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateImage>(this.candidateImageDao.getByCandidateId(candidateId), "Candidate's Image listed");
	}

}
