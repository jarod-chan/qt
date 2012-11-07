package cn.fyg.qt.application.shared;

/**
 *应用于返回校验结果
 *like this:
 * new Result().pass().
 * new Result().fail().reason("reason").
 */
public class Result {
	
	private boolean pass;
	
	private String reason;

	public Result pass() {
		this.pass = true;
		return this;
	}
	
	public Result fail(){
		this.pass=false;
		return this;
	}
	
	
	public Result reason(String reason) {
		this.reason = reason;
		return this;
	}
	
	public boolean isPass() {
		return pass;
	}
	
	public String getReason() {
		return reason;
	}

}
