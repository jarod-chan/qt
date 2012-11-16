package cn.fyg.qt.interfaces.customer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.domain.model.ques.QuesState;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;


@Controller
@RequestMapping("/finish")
public class FinishCtl {
	
	private static final String PATH = "customer/";
	private interface Page {
		String FINISH = PATH + "finish";
	}
	
	@Autowired
	QuesService quesService;
	@Autowired
	KeyService keyService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toFinish(Map<String,Object> map){
		Long qtkey = sessionUtil.getValue(Constant.QTKEY);
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Ques ques = quesService.find(qtid);
		Key key = keyService.find(qtkey);
		map.put("ques", ques);
		map.put("reason", findReason(ques,key));
		return Page.FINISH;
	}
	
	private String findReason(Ques ques, Key key) {
		if(ques.getState()!=QuesState.active){
			return String.format("【%s】已%s", ques.getName(),ques.getState().getName());
		}
		return String.format("认证码【%s】%s",key.getQtkey(),key.getState().getName());
	}

	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(Map<String,Object> map){
		sessionUtil.invalidate();
		return "redirect:/verify";
	}

}
