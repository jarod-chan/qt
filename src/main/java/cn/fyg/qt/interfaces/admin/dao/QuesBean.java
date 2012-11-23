package cn.fyg.qt.interfaces.admin.dao;

import cn.fyg.qt.domain.model.ques.Ques;

public class QuesBean {
	
	private Ques ques;
	
	private Long validNum;//有效个数
	
	private Long finishNum;//已完成

	public Ques getQues() {
		return ques;
	}

	public void setQues(Ques ques) {
		this.ques = ques;
	}

	public Long getValidNum() {
		return validNum;
	}

	public void setValidNum(Long validNum) {
		this.validNum = validNum;
	}

	public Long getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(Long finishNum) {
		this.finishNum = finishNum;
	}
	
	

}
