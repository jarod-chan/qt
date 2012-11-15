package cn.fyg.qt.domain.model.keypairLog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qt_keypairlog")
public class KeypairLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;//调查字串，12位数字

	private Long qtkey;//调查问卷id
	
	private Long prizeKey;//奖品key 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQtkey() {
		return qtkey;
	}

	public void setQtkey(Long qtkey) {
		this.qtkey = qtkey;
	}

	public Long getPrizeKey() {
		return prizeKey;
	}

	public void setPrizeKey(Long prizeKey) {
		this.prizeKey = prizeKey;
	}
	
	

}
