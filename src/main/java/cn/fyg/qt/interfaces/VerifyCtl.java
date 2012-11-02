package cn.fyg.qt.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/verify")
public class VerifyCtl {
	
	private static final String PATH = "";
	private interface Page {
		String VERIFY = PATH + "verify";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toVerify(){
		return Page.VERIFY;
	}

}
