package cn.fyg.qt.domain.model.key;

import cn.fyg.qt.infrastructure.tool.Generator;

public class KeyFactory {
	
	public static Key create(Long qtid){
		Key key=new Key();
		key.setQtkey(Generator.generateNumberKey(8));
		key.setQtid(qtid);
		key.setState(KeyState.nouse);
		return key;
	}

}
