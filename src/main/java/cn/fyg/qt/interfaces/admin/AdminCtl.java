package cn.fyg.qt.interfaces.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.qt.application.AdminService;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.message.Message;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;


@Controller
@RequestMapping("/am")
public class AdminCtl {
	
	private static final String PATH = "admin/";
	private interface Page {
		String ADMIN = PATH + "admin";
	}
	
	@Autowired
	AdminService adminService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toLogin(){
		return Page.ADMIN;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login(String name,String password,RedirectAttributes redirectAttributes){
		boolean isPass=adminService.check(name, password);
		if(isPass){
			sessionUtil.setValue(Constant.AUTH, true);
			return "redirect:/am/ques";
		}
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("用户密码有误,请重新输入！"));
		redirectAttributes.addFlashAttribute("name", name);
		return "redirect:/am";
	}
	

}
