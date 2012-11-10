package cn.fyg.qt.interfaces.customer.dto.show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.fyg.qt.domain.model.answer.Answer;
import cn.fyg.qt.domain.model.choice.Choice;

public class QuestionBuilder {

	public static List<Question> create(List<Choice> choiceList,List<Answer> answerList) {
		ArrayList<Question> questionList = new ArrayList<Question>();
		Map<Long,Long> answerMap=new HashMap<Long,Long>();
		for (Answer answer : answerList) {
			answerMap.put(answer.getValue(), answer.getId());
		}
		for (Choice choice : choiceList) {
			Question question = new Question();
			question.setChoice(choice);
			question.groupOptionByType();
			question.initAnswer(answerMap);
			questionList.add(question);
		}
		return questionList;
	}
	

}
