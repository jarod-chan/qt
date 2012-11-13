package cn.fyg.qt.domain.model.ques;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

public interface QuesRepository extends Repository<Ques,Long> {
	
	Ques findOne(Long qtid);

	List<Ques> findAll(Sort sort);
		
}
