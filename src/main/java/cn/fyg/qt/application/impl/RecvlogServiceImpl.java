package cn.fyg.qt.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.RecvlogService;
import cn.fyg.qt.domain.model.recvlog.Recvlog;
import cn.fyg.qt.domain.model.recvlog.RecvlogFactory;
import cn.fyg.qt.domain.model.recvlog.RecvlogRepository;

@Service
public class RecvlogServiceImpl implements RecvlogService {
	
	@Autowired
	RecvlogRepository recvlogRepository;

	@Override
	public Recvlog create(Long qtid, Long centerId, Long prizeKey, Long prizeId) {
		return RecvlogFactory.create(qtid, centerId, prizeKey, prizeId);
	}

	@Override
	@Transactional
	public Recvlog save(Recvlog recvlog) {
		return recvlogRepository.save(recvlog);
	}

	@Override
	public Recvlog findByPirzeKey(Long prizeKey) {
		return recvlogRepository.findByPrizeKey(prizeKey);
	}

}
