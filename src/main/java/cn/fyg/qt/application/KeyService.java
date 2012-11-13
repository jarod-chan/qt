package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.key.Key;

public interface KeyService {
	
	boolean check(Long qtkey);
	
	Key find(Long qtkey);
	
	void used(Long qtkey);
	
	void finish(Long qtkey);

}
