package cn.fyg.qt.interfaces.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.application.facade.customer.FillFacade;
import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.key.KeyState;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.interfaces.customer.dto.receive.ReceivePage;
import cn.fyg.qt.interfaces.customer.dto.show.Question;
import cn.fyg.qt.interfaces.customer.dto.show.SimpleAnswer;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.message.Message;
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
	KeyService keyService;
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
		List<Question> questionList=fillFacade.getQuestionList(qtid, qtkey);
		List<SimpleAnswer> simpleAnswerList = fillFacade.getSimpleAnswer(qtid, qtkey);
		map.put("questionList", questionList);
		map.put("simpleAnswerList", simpleAnswerList);
		return Page.FILL;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String fill(ReceivePage receivePage,RedirectAttributes redirectAttributes){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Long qtkey = sessionUtil.getValue(Constant.QTKEY);
		
		Key key = keyService.find(qtkey);
		//过滤重复提交等问题
		if(key.getState()!=KeyState.used){
			redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.info().message("你的操作被系统拒绝，请重新输入【调查码】，确认你已完成调查！",qtkey));
			return "redirect:/verify";
		}
		Long prizeKey=fillFacade.fill(receivePage, qtid, qtkey);
		sessionUtil.setValue(Constant.PRIZE_KEY, prizeKey);
		return "redirect:/sucess";
	}

}
