package cn.fyg.qt.interfaces.customer;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.ques.Ques;
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
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toFinish(Map<String,Object> map){
		Long qtkey = sessionUtil.getValue(Constant.QTKEY);
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Ques ques = quesService.find(qtid);
		map.put("ques", ques);
		map.put("qtkey", qtkey);
		return Page.FINISH;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(Map<String,Object> map,HttpSession session){
		sessionUtil.invalidate();
		return "redirect:/verify";
	}

}
