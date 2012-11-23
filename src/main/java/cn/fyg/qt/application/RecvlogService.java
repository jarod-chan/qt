package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.recvlog.Recvlog;

public interface RecvlogService {
	
	Recvlog create(Long qtid,Long centerId,Long prizeKey,Long prizeId);
	
	Recvlog save(Recvlog recvlog);

	Recvlog findByPirzeKey(Long prizeKey);
}
