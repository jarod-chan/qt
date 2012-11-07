package cn.fyg.qt.application;

import java.util.List;

import cn.fyg.qt.domain.model.ques.Ques;

public interface QuesService {
	
	Ques find(Long qtid);

	List<Ques> findByQtidAsc();
}
