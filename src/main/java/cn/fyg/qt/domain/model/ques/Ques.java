package cn.fyg.qt.domain.model.ques;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *问卷调查
 */
@Entity
@Table(name="qt_ques")
public class Ques {
	@Id
	private Long qtid;
	
	private String name;//调查问卷名称
	
	@Enumerated(EnumType.STRING)
	private QuesState state;//问卷执行状态

	public Long getQtid() {
		return qtid;
	}

	public void setQtid(Long qtid) {
		this.qtid = qtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuesState getState() {
		return state;
	}

	public void setState(QuesState state) {
		this.state = state;
	}

	

}
