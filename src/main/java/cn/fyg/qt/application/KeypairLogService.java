package cn.fyg.qt.application;

import cn.fyg.qt.domain.model.keypairLog.KeypairLog;

public interface KeypairLogService {
	
	KeypairLog log(Long qtkey,Long prizeKey);

}
