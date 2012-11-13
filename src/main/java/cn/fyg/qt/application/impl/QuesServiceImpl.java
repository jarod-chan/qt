package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.domain.model.ques.QuesRepository;
import cn.fyg.qt.domain.model.ques.QuesState;

@Service
public class QuesServiceImpl implements QuesService {
	
	@Autowired
	QuesRepository quesRepository;

	@Override
	public Ques find(Long qtid) {
		return quesRepository.findOne(qtid);
	}

	@Override
	public List<Ques> findByQtidAsc() {
		return quesRepository.findAll(new Sort(Sort.Direction.ASC,"qtid"));
	}

	@Override
	@Transactional
	public void finish(Long qtid) {
		Ques ques = quesRepository.findOne(qtid);
		ques.setState(QuesState.finish);
	}

	@Override
	@Transactional
	public void close(Long qtid) {
		Ques ques = quesRepository.findOne(qtid);
		ques.setState(QuesState.close);
	}


}
