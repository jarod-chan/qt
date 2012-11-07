package cn.fyg.qt.domain.model.prizekey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 领奖字串，用于领奖时认证
 */
@Entity
@Table(name="qt_prizekey")
public class PrizeKey {
	
	@Id
	private Long prizeKey;//获奖字串，12位数字
	
	private Long qtid;
	
	private PrizeState prizeState;

	public Long getPrizeKey() {
		return prizeKey;
	}

	public void setPrizeKey(Long prizeKey) {
		this.prizeKey = prizeKey;
	}

	public Long getQtid() {
		return qtid;
	}

	public void setQtid(Long qtid) {
		this.qtid = qtid;
	}

	public PrizeState getPrizeState() {
		return prizeState;
	}

	public void setPrizeState(PrizeState prizeState) {
		this.prizeState = prizeState;
	}
	
}
