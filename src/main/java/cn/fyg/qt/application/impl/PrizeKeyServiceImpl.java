package cn.fyg.qt.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.PrizeKeyService;
import cn.fyg.qt.domain.model.prizekey.PrizeKey;
import cn.fyg.qt.domain.model.prizekey.PrizeKeyFactory;
import cn.fyg.qt.domain.model.prizekey.PrizeKeyRepository;
import cn.fyg.qt.domain.model.prizekey.PrizeState;

@Service
public class PrizeKeyServiceImpl implements PrizeKeyService {

	@Autowired
	PrizeKeyRepository prizeKeyRepository;
	
	@Override
	public boolean check(Long prizeKey,Long qtid) {
		PrizeKey key = prizeKeyRepository.findByPrizeKeyAndQtid(prizeKey, qtid);
		if(key==null){
			return false;
		}
		return true;
	}

	@Override
	public PrizeKey find(Long prizeKey) {
		return prizeKeyRepository.findOne(prizeKey);
	}

	@Override
	@Transactional
	public void used(Long prizeKey) {
		PrizeKey key = prizeKeyRepository.findOne(prizeKey);
		key.setPrizeState(PrizeState.used);
	}

	@Override
	public PrizeKey create(Long qtid) {
		return PrizeKeyFactory.create(qtid);
	}

	@Override
	@Transactional
	public PrizeKey save(PrizeKey prizeKey) {
		return prizeKeyRepository.save(prizeKey);
	}

}
