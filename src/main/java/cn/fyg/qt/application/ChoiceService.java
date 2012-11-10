package cn.fyg.qt.application;

import java.util.List;

import cn.fyg.qt.domain.model.choice.Choice;

public interface ChoiceService {
	
	List<Choice> findByQtid(Long qtid);

}
