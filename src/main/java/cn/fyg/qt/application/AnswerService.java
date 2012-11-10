package cn.fyg.qt.application;

import java.util.List;

import cn.fyg.qt.domain.model.answer.Answer;

public interface AnswerService {

	Answer create(Long qtid,Long qtkey);
	
	Answer find(Long id);
	
	void save(List<Answer> asnwerList);
	
	List<Answer> findByQtidAndQtkey(Long qtid,Long qtkey);
	
}
