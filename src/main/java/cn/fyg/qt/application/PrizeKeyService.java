package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.prizekey.PrizeKey;


public interface PrizeKeyService {
	
	boolean check(Long prizeKey,Long qtid);
	
	PrizeKey create(Long qtid);
	
	PrizeKey find(Long prizeKey);
	
	PrizeKey save(PrizeKey prizeKey);
	
	void used(Long prizeKey);
}
