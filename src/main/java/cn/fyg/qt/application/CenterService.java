package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.center.Center;

public interface CenterService {
	
	boolean check(String idname,String password);
	
	Center findByIdname(String idname);

	Center find(Long id);
}
