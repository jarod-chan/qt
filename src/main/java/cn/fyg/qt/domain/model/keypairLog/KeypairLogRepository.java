package cn.fyg.qt.domain.model.keypairLog;

import org.springframework.data.repository.Repository;

public interface KeypairLogRepository extends Repository<KeypairLog, Long> {
	
	KeypairLog save(KeypairLog keypairLog);
	
	KeypairLog findOne(Long id);
	
	KeypairLog findByQtkey(Long qtkey);

	KeypairLog findByPrizeKey(Long prizeKey);
}
