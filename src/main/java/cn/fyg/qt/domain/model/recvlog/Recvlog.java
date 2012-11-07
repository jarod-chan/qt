package cn.fyg.qt.domain.model.recvlog;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *领奖记录：记录奖品领用记录，id为自增
 */
@Entity
@Table(name="qt_recvlog")
public class Recvlog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long qtid;//调查id
	
	private Long prizeKey;//领奖key
	
	@Column(name="center_id")
	private Long centerId;//领奖中心id
	
	@Column(name="prize_id")
	private Long prizeId;//奖品id
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date recdate;//获奖日期

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

	public Long getPrizeKey() {
		return prizeKey;
	}

	public void setPrizeKey(Long prizeKey) {
		this.prizeKey = prizeKey;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public Long getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(Long prizeId) {
		this.prizeId = prizeId;
	}

	public Date getRecdate() {
		return recdate;
	}

	public void setRecdate(Date recdate) {
		this.recdate = recdate;
	}
	
	
	
}
