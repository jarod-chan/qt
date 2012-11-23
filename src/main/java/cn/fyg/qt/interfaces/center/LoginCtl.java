package cn.fyg.qt.interfaces.center;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.qt.application.CenterService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.center.Center;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.domain.model.ques.QuesState;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.message.Message;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;

@Controller
@RequestMapping("/ct")
public class LoginCtl {
	
	private static final String PATH = "center/";
	private interface Page {
		String LOGIN = PATH + "login";
	}
	
	@Autowired
	CenterService centerService;
	@Autowired
	QuesService quesService;
	@Autowired
	SessionUtil sessionUtil;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toLogin(Map<String,Object> map){
		List<Center> centerList = centerService.findByQtid(1L);
		map.put("centerList", centerList);
		return Page.LOGIN;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login(String idname,String password,RedirectAttributes redirectAttributes){
		boolean isPass=centerService.check(idname, password);
		if(isPass){
			return passRedirect(idname);
		}
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("用户密码有误,请重新输入！"));
		redirectAttributes.addFlashAttribute("idname", idname);
		return "redirect:/ct";
	}

	private String passRedirect(String idname) {
		Center center = centerService.findByIdname(idname);
		Ques ques = quesService.find(center.getQtid());
		if(center!=null&&ques!=null){
			sessionUtil.setValue(Constant.AUTH, true);
			sessionUtil.setValue(Constant.QTID, ques.getQtid());
			sessionUtil.setValue(Constant.CENTER_ID, center.getId());
		}
		return redirectByQuesState(ques.getState());
	}
	
	private String redirectByQuesState(QuesState state) {
		if(QuesState.active==state||QuesState.finish==state){
			return "redirect:/ct/receive";
		}
		return "redirect:/ct/close";
	}
	
	
}
