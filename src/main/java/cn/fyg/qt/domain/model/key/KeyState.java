package cn.fyg.qt.domain.model.key;

import cn.fyg.qt.domain.shared.CommonEnum;

public enum KeyState implements CommonEnum {
	nouse("未使用"),//初始生成状态
	used("已使用"),//已使用，但是只是部分完成
	finish("已完成"),//有效回收字串
	invalid("无效");//无效回收字串
	
	private String name;
	
	private KeyState(String name){
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	
}
