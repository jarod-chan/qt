package cn.fyg.qt.interfaces.center;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ct")
public class CenterCtl {
	
	private static final String PATH = "center/";
	private interface Page {
		String LOGIN = PATH + "login";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toLogin(){
		return Page.LOGIN;
	}
}
