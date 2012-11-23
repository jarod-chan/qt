package cn.fyg.qt.domain.model.key;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *校验码
 */
@Entity
@Table(name="qt_key")
public class Key {
	
	@Id
	private Long  qtkey;//调查字串，12位数字

	private Long qtid;//调查问卷id
	
	@Enumerated(EnumType.STRING)
	private KeyState state;//uuid使用情况

	public Long getQtkey() {
		return qtkey;
	}

	public void setQtkey(Long qtkey) {
		this.qtkey = qtkey;
	}

	public Long getQtid() {
		return qtid;
	}

	public void setQtid(Long qtid) {
		this.qtid = qtid;
	}

	public KeyState getState() {
		return state;
	}

	public void setState(KeyState state) {
		this.state = state;
	}
	
	
}
