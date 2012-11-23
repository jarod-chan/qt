package cn.fyg.qt.domain.model.prizekey;

import org.springframework.data.repository.Repository;

public interface PrizeKeyRepository extends Repository<PrizeKey, Long> {
	
	PrizeKey findOne(Long prizeKey);
	
	PrizeKey findByPrizeKeyAndQtid(Long prizeKey,Long qtid);
	
	PrizeKey save(PrizeKey prizeKey);
}
