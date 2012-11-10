package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.AnswerService;
import cn.fyg.qt.domain.model.answer.Answer;
import cn.fyg.qt.domain.model.answer.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;

	@Override
	public Answer create(Long qtid, Long qtkey) {
		Answer answer=new Answer();
		answer.setQtid(qtid);
		answer.setQtkey(qtkey);
		return answer;
	}

	@Override
	public List<Answer> findByQtidAndQtkey(Long qtid, Long qtkey) {
		return answerRepository.findByQtidAndQtkey(qtid, qtkey);
	}

	@Override
	public Answer find(Long id) {
		return answerRepository.findOne(id);
	}

	@Override
	@Transactional
	public void save(List<Answer> asnwerList) {
		answerRepository.save(asnwerList);
	}

}
