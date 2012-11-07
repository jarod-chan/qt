package cn.fyg.qt.domain.model.prize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *奖品
 */
@Entity
@Table(name="qt_prize")
public class Prize {
	
	@Id
	private Long id;
	
	private Long qtid;//调查id
	
	private String name;//奖品名称

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
