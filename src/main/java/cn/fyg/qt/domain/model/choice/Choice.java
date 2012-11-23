package cn.fyg.qt.domain.model.choice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="qt_choice")
public class Choice {
	@Id
	private Long id;
	
	private Long qtid;//调查问卷id
	
	private Long no;//序号,控制问题顺序
	
	private String subject;//问题内容
	
	@OneToMany(fetch = FetchType.EAGER, 
			cascade = {CascadeType.ALL},
			targetEntity = Option.class)
	@JoinColumn(name="choice_id")
	@OrderBy("type ASC,no ASC")
	private List<Option> options;//问题答案

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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	
}
