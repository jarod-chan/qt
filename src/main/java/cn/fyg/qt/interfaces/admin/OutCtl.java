package cn.fyg.qt.interfaces.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fyg.qt.interfaces.shared.session.SessionUtil;

@Controller
@RequestMapping("/am/logout")
public class OutCtl {
	
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String logout(){
		sessionUtil.invalidate();
		return "redirect:/am";
	}

}
