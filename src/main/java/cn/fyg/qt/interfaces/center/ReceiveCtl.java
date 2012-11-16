package cn.fyg.qt.interfaces.center;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.qt.application.CenterService;
import cn.fyg.qt.application.PrizeKeyService;
import cn.fyg.qt.application.PrizeService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.application.RecvlogService;
import cn.fyg.qt.domain.model.center.Center;
import cn.fyg.qt.domain.model.prizekey.PrizeKey;
import cn.fyg.qt.domain.model.prizekey.PrizeState;
import cn.fyg.qt.domain.model.recvlog.Recvlog;
import cn.fyg.qt.infrastructure.tool.Format;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.message.Message;
import cn.fyg.qt.interfaces.shared.session.SessionUtil;

@Controller
@RequestMapping("/ct/receive")
public class ReceiveCtl {
	private static final String PATH = "center/";
	private interface Page {
		String RECEIVE = PATH + "receive";
	}
	
	@Autowired
	CenterService centerService;
	@Autowired
	QuesService quesService;
	@Autowired
	PrizeService prizeService;
	@Autowired
	PrizeKeyService prizeKeyService;
	@Autowired
	RecvlogService recvlogService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toReceive(Map<String,Object> map){
		Long centerId=sessionUtil.getValue(Constant.CENTER_ID); 
		Center center = centerService.find(centerId);
		map.put("center", center);
		return Page.RECEIVE;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String receive(String prizeKey,RedirectAttributes redirectAttributes){
		Long longPrizeKey=Format.parseLong(prizeKey, 0L);
		Long qtid = sessionUtil.getValue(Constant.QTID);
		boolean isPass=prizeKeyService.check(longPrizeKey,qtid);
		if(!isPass){
			redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("领取码[%s]认证失败，请确认以后重新输入！",prizeKey));
			redirectAttributes.addFlashAttribute("prizeKey", prizeKey);
			return "redirect:/ct/receive";
		}
		PrizeKey key = prizeKeyService.find(longPrizeKey);
		if(PrizeState.used==key.getPrizeState()){
			Recvlog recvlog = recvlogService.findByPirzeKey(key.getPrizeKey());
			Center center = centerService.find(recvlog.getCenterId());
			redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("领取码[%s]已经于[%s]在%s被领取，不能重复领取！",prizeKey,Format.formatDate(recvlog.getRecdate()),center.getRealname()));
			redirectAttributes.addFlashAttribute("prizeKey", prizeKey);
			return "redirect:/ct/receive";
		}
		redirectAttributes.addFlashAttribute("longPrizeKey", longPrizeKey);
		return "redirect:/ct/confirm";
	}
}
