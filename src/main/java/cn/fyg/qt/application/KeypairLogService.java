package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.keypairLog.KeypairLog;
import cn.fyg.qt.domain.model.prizekey.PrizeKey;

public interface KeypairLogService {
	
	KeypairLog log(Long qtkey,Long prizeKey);
	
	PrizeKey findPrizeKeyByQtkey(Long qtkey);

}
