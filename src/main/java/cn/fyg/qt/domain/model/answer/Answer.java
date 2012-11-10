package cn.fyg.qt.domain.model.answer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qt_answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long qtid;//调查问卷id
	
	private Long qtkey;//用户id
	
	private Long value;//值，选择的答案id

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

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
}
