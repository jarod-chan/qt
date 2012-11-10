package cn.fyg.qt.interfaces.customer.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.fyg.qt.application.AnswerService;
import cn.fyg.qt.domain.model.answer.Answer;
import cn.fyg.qt.interfaces.customer.dto.receive.ReceiveBean;
import cn.fyg.qt.interfaces.customer.dto.receive.ReceivePage;

@Component
public class FillFacade {
	
	@Autowired
	AnswerService answerService;
	
	public void saveChoice(ReceivePage receivePage,Long qtid,Long qtkey){
		List<Answer> answerList=new ArrayList<Answer>();
		for (ReceiveBean receiveBean : receivePage.getReceiveBeans()) {
			if(receiveBean.getValue()!=null){
				Answer answer = receiveBean.getId() == null ? 
						answerService.create(qtid,qtkey) : 
						answerService.find(receiveBean.getId());
				answer.setValue(receiveBean.getValue());
				answerList.add(answer);
			}
		}
		answerService.save(answerList);
	}



}
