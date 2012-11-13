package cn.fyg.qt.domain.model.key;

import cn.fyg.qt.infrastructure.tool.Tool;

public class KeyFactory {
	
	public static Key create(Long qtid){
		Key key=new Key();
		key.setQtkey(Tool.generateNumberKey(8));
		key.setQtid(qtid);
		key.setState(KeyState.nouse);
		return key;
	}

}
