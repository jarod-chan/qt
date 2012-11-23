package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.key.KeyState;

public interface KeyService {
	
	boolean check(Long qtkey);
	
	Key find(Long qtkey);
	
	Key create(Long qtid);
	
	Key save(Key key);
	
	void used(Long qtkey);
	
	void finish(Long qtkey);
	
	Long countByQuesState(Long qtid,KeyState... keyState);

}
