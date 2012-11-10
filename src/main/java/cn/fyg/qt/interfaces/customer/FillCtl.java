package cn.fyg.qt.interfaces.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fyg.qt.application.AnswerService;
import cn.fyg.qt.application.ChoiceService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.answer.Answer;
import cn.fyg.qt.domain.model.choice.Choice;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.interfaces.customer.dto.receive.ReceivePage;
import cn.fyg.qt.interfaces.customer.dto.show.Question;
import cn.fyg.qt.interfaces.customer.dto.show.QuestionBuilder;
import cn.fyg.qt.interfaces.customer.facade.FillFacade;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;

@Controller
@RequestMapping("/fill")
public class FillCtl {
	
	private static final String PATH = "customer/";
	private interface Page {
		String FILL = PATH + "fill";
	}
	
	@Autowired
	QuesService quesService;
	@Autowired
	ChoiceService choiceService;
	@Autowired
	AnswerService answerService;
	@Autowired
	FillFacade fillFacade;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toFill(Map<String,Object> map){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Long qtkey = sessionUtil.getValue(Constant.QTKEY);
		Ques ques = quesService.find(qtid);
		map.put("ques", ques);
		List<Choice> choiceList = choiceService.findByQtid(qtid);
		List<Answer> answerList = answerService.findByQtidAndQtkey(qtid, qtkey);
		List<Question> questionList=QuestionBuilder.create(choiceList,answerList);
		map.put("questionList", questionList);
		return Page.FILL;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String fill(ReceivePage receivePage,Map<String,Object> map){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Long qtkey = sessionUtil.getValue(Constant.QTKEY);
		
		
		
		return Page.FILL;
	}

}
