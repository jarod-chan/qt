package cn.fyg.qt.interfaces.customer.dto.receive;

import java.util.List;

public class ReceivePage {
	
	
	List<ReceiveBean> receiveBeans;
	
	List<ReplayBean> replayBeans;

	public List<ReceiveBean> getReceiveBeans() {
		return receiveBeans;
	}

	public void setReceiveBeans(List<ReceiveBean> receiveBeans) {
		this.receiveBeans = receiveBeans;
	}

	public List<ReplayBean> getReplayBeans() {
		return replayBeans;
	}

	public void setReplayBeans(List<ReplayBean> replayBeans) {
		this.replayBeans = replayBeans;
	}

}
