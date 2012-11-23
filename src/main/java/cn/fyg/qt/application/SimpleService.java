package cn.fyg.qt.application;

import java.util.List;

import cn.fyg.qt.domain.model.simple.Simple;

public interface SimpleService {
	
	List<Simple> findByQtid(Long qtid);
}
