package cn.fyg.qt.interfaces.center;

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
@RequestMapping("/ct/close")
public class CloseCtl {
	
	private static final String PATH = "center/";
	private interface Page {
		String CLOSE = PATH + "close";
	}

	@Autowired
	QuesService quesService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toClose(Map<String,Object> map){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Ques ques = quesService.find(qtid);
		map.put("ques", ques);
		return Page.CLOSE;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(Map<String,Object> map,HttpSession session){
		sessionUtil.invalidate();
		return "redirect:/ct";
	}

}
