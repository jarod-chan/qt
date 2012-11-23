package cn.fyg.qt.domain.model.ques;

import cn.fyg.qt.domain.shared.CommonEnum;


public enum QuesState implements CommonEnum {
	init("初始化"),//生成认证字串等初始工作
	active("执行中"),//调查开发执行中
	finish("结束"),//调查结束，不再接受问卷输入
	close("关闭");//奖品发放失效，不在接受奖品领取
	
	private String name;
	
	private QuesState(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}


}
