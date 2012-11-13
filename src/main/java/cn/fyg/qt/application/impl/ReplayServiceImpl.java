package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.ReplayService;
import cn.fyg.qt.domain.model.replay.Replay;
import cn.fyg.qt.domain.model.replay.ReplayFactory;
import cn.fyg.qt.domain.model.replay.ReplayRepository;

@Service
public class ReplayServiceImpl implements ReplayService {
	
	@Autowired
	ReplayRepository replayRepository;

	@Override
	public List<Replay> findByQtidAndQtkey(Long qtid, Long qtkey) {
		return replayRepository.findByQtidAndQtkey(qtid, qtkey);
	}

	@Override
	@Transactional
	public void save(List<Replay> replayList) {
		for (Replay replay : replayList) {
			replayRepository.save(replay);
		}
	}

	@Override
	public Replay create(Long qtid, Long qtkey) {
		return ReplayFactory.create(qtid, qtkey);
	}

	@Override
	public Replay find(Long id) {
		return replayRepository.findOne(id);
	}

}
