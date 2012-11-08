package cn.fyg.qt.interfaces.center.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.PrizeKeyService;
import cn.fyg.qt.application.RecvlogService;
import cn.fyg.qt.domain.model.recvlog.Recvlog;

@Component
public class ConfirmFacade {
	
	@Autowired
	RecvlogService recvlogService;
	@Autowired
	PrizeKeyService prizeKeyService;
	

	@Transactional
	public void confirm(Long qtid, Long centerId, Long prizeKey, Long prizeId) {
		Recvlog	recvlog=recvlogService.create(qtid, centerId, prizeKey, prizeId);
		recvlogService.save(recvlog);
		prizeKeyService.used(prizeKey);
	}

}
