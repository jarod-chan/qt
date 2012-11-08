package cn.fyg.qt.interfaces.center;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.qt.application.CenterService;
import cn.fyg.qt.application.PrizeService;
import cn.fyg.qt.domain.model.center.Center;
import cn.fyg.qt.domain.model.prize.Prize;
import cn.fyg.qt.interfaces.center.facade.ConfirmFacade;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;


@Controller
@RequestMapping("/ct/confirm")
public class ConfirmCtl {

	private static final String PATH = "center/";
	private interface Page {
		String CONFIRM = PATH + "confirm";
	}
	
	
	@Autowired
	ConfirmFacade confirmFacade;
	@Autowired
	CenterService centerService;
	@Autowired
	PrizeService prizeService;
	@Autowired
	SessionUtil sessionUtil;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toConfirm(Map<String,Object> map){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Long centerId=sessionUtil.getValue(Constant.CENTER_ID); 
		Center center = centerService.find(centerId);
		map.put("center", center);
		List<Prize> prizeList = prizeService.findByQtid(qtid);
		map.put("prizeList", prizeList);
		return Page.CONFIRM;
	}
	

	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String confirm(Long prizeKey,Long prizeId,RedirectAttributes redirectAttributes){
		Long qtid = sessionUtil.getValue(Constant.QTID);
		Long centerId=sessionUtil.getValue(Constant.CENTER_ID); 
		confirmFacade.confirm(qtid, centerId, prizeKey, prizeId);
		Prize prize = prizeService.find(prizeId);
		redirectAttributes.addFlashAttribute("prizeKey", prizeKey);
		redirectAttributes.addFlashAttribute("prizeName", prize.getName());
		return "redirect:/ct/sucess";
	}
}
