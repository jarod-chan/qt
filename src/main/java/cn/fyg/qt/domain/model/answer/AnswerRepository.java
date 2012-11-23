package cn.fyg.qt.domain.model.answer;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface AnswerRepository extends Repository<Answer, Long> {
	
	List<Answer> findByQtidAndQtkey(Long qtid,Long qtkey);
	
	Answer findOne(Long id);
	
	Iterable<Answer> save(Iterable<Answer> answers);
 
}
