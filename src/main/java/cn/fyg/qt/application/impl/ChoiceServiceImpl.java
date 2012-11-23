package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fyg.qt.application.ChoiceService;
import cn.fyg.qt.domain.model.choice.Choice;
import cn.fyg.qt.domain.model.choice.ChoiceRepository;

@Service
public class ChoiceServiceImpl implements ChoiceService {

	@Autowired
	ChoiceRepository choiceRepository;
	
	@Override
	public List<Choice> findByQtid(Long qtid) {
		return choiceRepository.findByQtidOrderByIdAsc(qtid);
	}

}
