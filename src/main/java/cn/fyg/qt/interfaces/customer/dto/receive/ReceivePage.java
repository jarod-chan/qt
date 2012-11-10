package cn.fyg.qt.interfaces.customer.dto.receive;

import java.util.List;

public class ReceivePage {
	
	private boolean finish;
	
	List<ReceiveBean> receiveBeans;

	public List<ReceiveBean> getReceiveBeans() {
		return receiveBeans;
	}

	public void setReceiveBeans(List<ReceiveBean> receiveBeans) {
		this.receiveBeans = receiveBeans;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	
}
