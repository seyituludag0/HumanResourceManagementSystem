package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvDetail;

public interface CvDetailDao extends JpaRepository<CvDetail, Integer>{

	CvDetail getByCandidate_Id(int candidateId);
	
}
