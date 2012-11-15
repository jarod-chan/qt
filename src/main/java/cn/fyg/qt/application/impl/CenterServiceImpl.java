package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fyg.qt.application.CenterService;
import cn.fyg.qt.domain.model.center.Center;
import cn.fyg.qt.domain.model.center.CenterRepository;

@Service
public class CenterServiceImpl implements CenterService {
	
	@Autowired
	CenterRepository centerRepository;

	@Override
	public boolean check(String idname, String password) {
		Center center = centerRepository.findByIdname(idname);
		if(center==null) return false;
		return center.getPassword().equals(password);
	}

	@Override
	public Center findByIdname(String idname) {
		return centerRepository.findByIdname(idname);
	}

	@Override
	public Center find(Long id) {
		return centerRepository.findOne(id);
	}

	@Override
	public List<Center> findByQtid(Long qtid) {
		return centerRepository.findByQtidOrderByIdAsc(qtid);
	}

}
