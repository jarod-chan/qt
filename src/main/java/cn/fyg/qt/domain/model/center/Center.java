package cn.fyg.qt.domain.model.center;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *奖品分发中心
 */
@Entity
@Table(name="qt_center")
public class Center {
	
	@Id
	private Long id;
	
	private Long qtid;//调查id
	
	private String idname;//认证名，不可重复
	
	private String password;//密码
	
	private String realname;//显示名： 方便用户识别

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

	public String getIdname() {
		return idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	

}
