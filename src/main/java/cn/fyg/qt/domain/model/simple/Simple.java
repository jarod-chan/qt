package cn.fyg.qt.domain.model.simple;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *简答题
 */
@Entity
@Table(name="qt_simple")
public class Simple {
	
	@Id
	private Long id;
	
	private Long qtid;//调查问卷id
	
	private Long no;//序号,控制问题顺序
	
	private String subject;//问题内容

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

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
