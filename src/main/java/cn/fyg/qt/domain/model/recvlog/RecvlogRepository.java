package cn.fyg.qt.domain.model.recvlog;

import org.springframework.data.repository.Repository;

public interface RecvlogRepository extends Repository<Recvlog, Long> {
	
	Recvlog save(Recvlog recvlog);
	
	Recvlog findByPrizeKey(Long prizeKey);

}
