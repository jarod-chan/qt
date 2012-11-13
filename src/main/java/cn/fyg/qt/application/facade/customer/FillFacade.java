package cn.fyg.qt.application.facade.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.AnswerService;
import cn.fyg.qt.application.ChoiceService;
import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.application.PrizeKeyService;
import cn.fyg.qt.application.ReplayService;
import cn.fyg.qt.application.SimpleService;
import cn.fyg.qt.domain.model.answer.Answer;
import cn.fyg.qt.domain.model.choice.Choice;
import cn.fyg.qt.domain.model.prizekey.PrizeKey;
import cn.fyg.qt.domain.model.replay.Replay;
import cn.fyg.qt.domain.model.simple.Simple;
import cn.fyg.qt.interfaces.customer.dto.receive.ReceiveBean;
import cn.fyg.qt.interfaces.customer.dto.receive.ReceivePage;
import cn.fyg.qt.interfaces.customer.dto.receive.ReplayBean;
import cn.fyg.qt.interfaces.customer.dto.show.Question;
import cn.fyg.qt.interfaces.customer.dto.show.QuestionBuilder;
import cn.fyg.qt.interfaces.customer.dto.show.SimpleAnswer;
import cn.fyg.qt.interfaces.customer.dto.show.SimpleAnswerBuilder;

@Component
public class FillFacade {
	
	@Autowired
	AnswerService answerService;
	@Autowired
	ChoiceService choiceService;
	@Autowired
	SimpleService simpleService;
	@Autowired
	ReplayService replayService;
	@Autowired
	KeyService keyService;
	@Autowired
	PrizeKeyService prizeKeyService;

	public List<Question> getQuestionList(Long qtid,Long qtkey){
		List<Choice> choiceList = choiceService.findByQtid(qtid);
		List<Answer> answerList = answerService.findByQtidAndQtkey(qtid, qtkey);
	    return QuestionBuilder.create(choiceList,answerList);
	}
	
	public List<SimpleAnswer> getSimpleAnswer(Long qtid,Long qtkey){
		List<Simple> simpleList = simpleService.findByQtid(qtid);
		List<Replay> replayList = replayService.findByQtidAndQtkey(qtid, qtkey);
		return SimpleAnswerBuilder.create(simpleList, replayList);
	}
	
	@Transactional
	public Long fill(ReceivePage receivePage, Long qtid, Long qtkey) {
		saveChoice(receivePage.getReceiveBeans(), qtid, qtkey);
		saveSimple(receivePage.getReplayBeans(), qtid, qtkey);
		keyService.finish(qtkey);
		PrizeKey prizeKey = prizeKeyService.create(qtid);
		prizeKey = prizeKeyService.save(prizeKey);
		return prizeKey.getPrizeKey();
	}
	
	
	public void saveChoice(List<ReceiveBean> ReceiveBeanList,Long qtid,Long qtkey){
		List<Answer> answerList=new ArrayList<Answer>();
		for (ReceiveBean receiveBean : ReceiveBeanList) {
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
	
	public void saveSimple(List<ReplayBean> replayBeans,Long qtid,Long qtkey){
		ArrayList<Replay> replayList = new ArrayList<Replay>();
		for (ReplayBean replayBean : replayBeans) {
			Replay replay = replayBean.getId()==null?
					replayService.create(qtid, qtkey):
					replayService.find(replayBean.getId());
			replay.setSimpleId(replayBean.getSimpleId());
			replay.setValue(replayBean.getValue());
			replayList.add(replay);
		}
		replayService.save(replayList);
	}





}
