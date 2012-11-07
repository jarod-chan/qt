package cn.fyg.qt.interfaces.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.domain.model.ques.QuesState;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.message.Message;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;
import cn.fyg.qt.interfaces.shared.tool.FormatTool;

@Controller
@RequestMapping("/verify")
public class VerifyCtl {
	
	public static final Logger logger=LoggerFactory.getLogger(VerifyCtl.class);
	
	private static final String PATH = "customer/";
	private interface Page {
		String VERIFY = PATH + "verify";
	}
	
	@Autowired
	KeyService keyService;
	@Autowired
	QuesService quesService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toVerify(){
		return Page.VERIFY;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String verify(String qtkey,RedirectAttributes redirectAttributes){
		logger.info(String.format("verify key:[%s]", qtkey));
		Long longQtkey=FormatTool.parseLong(qtkey, 0L);
		boolean isPass = keyService.check(longQtkey);
		if(isPass){
			return passRedirect(longQtkey);
		}
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.info().message("认证码[%s]认证失败，请确认以后重新输入！",qtkey));
		redirectAttributes.addFlashAttribute("qtkey", qtkey);
		return "redirect:/verify";
	}

	private String passRedirect(Long longQtkey) {
		Key key = keyService.find(longQtkey);
		Ques ques = quesService.find(key.getQtid());
		if(key!=null&&ques!=null){
			sessionUtil.setValue(Constant.AUTH, true);
			sessionUtil.setValue(Constant.QTID, ques.getQtid());
			sessionUtil.setValue(Constant.QTKEY, key.getQtkey());
		}
		return redirectByQuesState(ques.getState());
	}

	private String redirectByQuesState(QuesState state) {
		if(QuesState.active==state){
			return "redirect:/fill";
		}
		return "redirect:/finish";
	}

}
