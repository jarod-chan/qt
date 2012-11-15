package cn.fyg.qt.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.KeypairLogService;
import cn.fyg.qt.application.PrizeKeyService;
import cn.fyg.qt.domain.model.keypairLog.KeypairLog;
import cn.fyg.qt.domain.model.keypairLog.KeypairLogRepository;
import cn.fyg.qt.domain.model.prizekey.PrizeKey;

@Service
public class KeypairLogServiceImpl implements KeypairLogService {
	
	@Autowired
	KeypairLogRepository keypairLogRepository;
	@Autowired
	PrizeKeyService prizeKeyService;

	@Override
	@Transactional
	public KeypairLog log(Long qtkey, Long prizeKey) {
		KeypairLog keypairLog=new KeypairLog();
		keypairLog.setQtkey(qtkey);
		keypairLog.setPrizeKey(prizeKey);
		return keypairLogRepository.save(keypairLog);
	}

	@Override
	public PrizeKey findPrizeKeyByQtkey(Long qtkey) {
		KeypairLog keypairLog = keypairLogRepository.findByQtkey(qtkey);
		if(keypairLog!=null){			
			return prizeKeyService.find(keypairLog.getPrizeKey());
		}
		return null;
	}

}
