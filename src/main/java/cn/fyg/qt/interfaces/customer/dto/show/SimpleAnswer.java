package cn.fyg.qt.interfaces.customer.dto.show;

import cn.fyg.qt.domain.model.simple.Simple;

public class SimpleAnswer {
	
	private Simple simple;
	
	private Long id;
	
	private String value;

	public Simple getSimple() {
		return simple;
	}

	public void setSimple(Simple simple) {
		this.simple = simple;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
