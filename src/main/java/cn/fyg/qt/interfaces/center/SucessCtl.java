package cn.fyg.qt.interfaces.center;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fyg.qt.application.CenterService;
import cn.fyg.qt.domain.model.center.Center;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;

@Controller
@RequestMapping("/ct/sucess")
public class SucessCtl {

	private static final String PATH = "center/";
	private interface Page {
		String SUCESS = PATH + "sucess";
	}
	
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	CenterService centerService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toSucess(Map<String,Object> map){
		Long centerId=sessionUtil.getValue(Constant.CENTER_ID); 
		Center center = centerService.find(centerId);
		map.put("center", center);
		return Page.SUCESS;
	}
}
