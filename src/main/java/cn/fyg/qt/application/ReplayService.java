package cn.fyg.qt.application;

import java.util.List;

import cn.fyg.qt.domain.model.replay.Replay;

public interface ReplayService {
	
	List<Replay> findByQtidAndQtkey(Long qtid,Long qtkey);
	
	Replay create(Long qtid,Long qtkey);
	
	void save(List<Replay> replayList);
	
	Replay find(Long id);

}
