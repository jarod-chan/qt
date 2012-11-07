package cn.fyg.qt.domain.model.prizekey;

import cn.fyg.qt.domain.shared.CommonEnum;

public enum PrizeState implements CommonEnum {
	nouse("未使用"),
	used("已使用");

	private String name;
	
	private PrizeState(String name) {
		this.name=name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
