package cn.fyg.qt.interfaces.customer.dto.show;

import java.util.List;

import cn.fyg.qt.domain.model.choice.Option;

public class Item {
	
	private Long id;
	
	private Long value;
	
	private int type;
	
	private List <Option> options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	

}
