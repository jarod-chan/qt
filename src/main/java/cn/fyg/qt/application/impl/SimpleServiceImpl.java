package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fyg.qt.application.SimpleService;
import cn.fyg.qt.domain.model.simple.Simple;
import cn.fyg.qt.domain.model.simple.SimpleRepository;

@Service
public class SimpleServiceImpl implements SimpleService {

	@Autowired
	SimpleRepository repository;
	
	@Override
	public List<Simple> findByQtid(Long qtid) {
		return repository.findByQtidOrderByNoAsc(qtid);
	}

}
