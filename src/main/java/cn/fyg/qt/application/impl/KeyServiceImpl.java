package cn.fyg.qt.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.key.KeyRepository;

@Service
public class KeyServiceImpl implements KeyService {
	
	@Autowired
	KeyRepository keyRepository;

	@Override
	public boolean check(Long qtkey) {
		Key key = keyRepository.findOne(qtkey);
		if(key!=null){
			return true;
		}
		return false;
	}

	@Override
	public Key find(Long qtkey) {
		return keyRepository.findOne(qtkey);
	}

}
