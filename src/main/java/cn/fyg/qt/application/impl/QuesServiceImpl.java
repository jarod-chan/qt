package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.domain.model.ques.QuesRepository;

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

}
