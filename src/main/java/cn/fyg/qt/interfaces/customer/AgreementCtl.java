package cn.fyg.qt.interfaces.customer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;

@Controller
@RequestMapping("/agreement")
public class AgreementCtl {
	
	private static final String PATH = "customer/";
	private interface Page {
		String AGREEMENT = PATH + "agreement";
	}
	
	@Autowired
	QuesService quesService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toAgreement(Map<String,Object> map){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Ques ques = quesService.find(qtid);
		map.put("ques", ques);
		return Page.AGREEMENT;
	}

}
