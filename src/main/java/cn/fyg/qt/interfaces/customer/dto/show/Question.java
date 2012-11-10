package cn.fyg.qt.interfaces.customer.dto.show;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.fyg.qt.domain.model.choice.Choice;
import cn.fyg.qt.domain.model.choice.Option;



public class Question {
	
	private Choice choice;
	
	private List<Item> items;
	
	public void groupOptionByType(){
		this.items=new ArrayList<Item>();
		int prevType=0;
		for (Option option: this.choice.getOptions()) {
			if(prevType!=option.getType()){
				prevType=option.getType();
				Item item=new Item();
				item.setOptions(new ArrayList<Option>());
				item.setType(prevType);
				this.items.add(item);
			}
			this.items.get(this.items.size()-1).getOptions().add(option);
		}
	}
	
	public void initAnswer(Map<Long, Long> answerMap) {
		for (Item item : this.items) {
			for (Option option : item.getOptions()) {
				Long answerId=answerMap.get(option.getId());
				if(answerId!=null){
					item.setId(answerId);
					item.setValue(option.getId());
					break;
				}
			}
		}
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
