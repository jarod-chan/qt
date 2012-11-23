package cn.fyg.qt.domain.model.replay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *简答题答案
 */
@Entity
@Table(name="qt_reply")
public class Replay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long qtid;//调查问卷id
	
	private Long qtkey;//用户id
	
	@Column(name="simple_id")
	private Long simpleId;//问题id
	
	@Column(length=512)
	private String value;//文本值

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQtid() {
		return qtid;
	}

	public void setQtid(Long qtid) {
		this.qtid = qtid;
	}

	public Long getQtkey() {
		return qtkey;
	}

	public void setQtkey(Long qtkey) {
		this.qtkey = qtkey;
	}

	public Long getSimpleId() {
		return simpleId;
	}

	public void setSimpleId(Long simpleId) {
		this.simpleId = simpleId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
