package cn.fyg.qt.domain.model.replay;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface ReplayRepository extends Repository<Replay, Long> {
	
	List<Replay> findByQtidAndQtkey(Long qtid,Long qtkey);
	
	Replay findOne(Long id);
	
	Replay save(Replay replay);
}
