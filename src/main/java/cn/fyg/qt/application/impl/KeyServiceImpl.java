package cn.fyg.qt.application.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.key.KeyFactory;
import cn.fyg.qt.domain.model.key.KeyRepository;
import cn.fyg.qt.domain.model.key.KeyState;

@Service
public class KeyServiceImpl implements KeyService {
	
	@Autowired
	KeyRepository keyRepository;

	@Override
	public boolean check(Long qtkey) {
		Key key = keyRepository.findOne(qtkey);
		if(key!=null){
			return KeyState.invalid != key.getState();
		}
		return false;
	}

	@Override
	public Key find(Long qtkey) {
		return keyRepository.findOne(qtkey);
	}

	@Override
	@Transactional
	public void used(Long qtkey) {
		Key key = keyRepository.findOne(qtkey);
		if(KeyState.used != key.getState()){
			key.setState(KeyState.used);
		}
	}

	@Override
	@Transactional
	public void finish(Long qtkey) {
		Key key = keyRepository.findOne(qtkey);
		if(KeyState.finish != key.getState()){
			key.setState(KeyState.finish);
		}
	}

	@Override
	public Long countByQuesState(Long qtid, KeyState... keyStates) {
		List<KeyState> arrayList = new ArrayList<KeyState>();
		for (KeyState keyState : keyStates) {
			arrayList.add(keyState);
		}
		return keyRepository.countByKeyState(qtid,arrayList);
	}

	@Override
	public Key create(Long qtid) {
		return KeyFactory.create(qtid);
	}

	@Override
	@Transactional
	public Key save(Key key) {
		return keyRepository.save(key);
	}


}
