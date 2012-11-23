package cn.fyg.qt.interfaces.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.application.facade.admin.QuesFacade;
import cn.fyg.qt.infrastructure.tool.Format;
import cn.fyg.qt.interfaces.admin.dao.QuesBean;
import cn.fyg.qt.interfaces.admin.dao.TrackBean;
import cn.fyg.qt.interfaces.shared.Constant.Constant;
import cn.fyg.qt.interfaces.shared.message.Message;


@Controller
@RequestMapping("/am/ques")
public class QuesCtl {
	
	private static final String PATH = "admin/";
	private interface Page {
		String QUES = PATH + "ques";
	}
	
	@Autowired
	QuesFacade quesFacade;
	@Autowired
	QuesService quesService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toQues(Map<String,Object> map){
		List<QuesBean> quesBeanList =quesFacade.getQuesBeanList();
		map.put("quesBeanList", quesBeanList);
		return Page.QUES;
	}

	@RequestMapping(value="/produceKey",method=RequestMethod.POST)
	public String produceKey(@RequestParam("qtid")Long qtid,@RequestParam("keyNum")int keyNum,RedirectAttributes redirectAttributes){
		quesFacade.produceKey(qtid, keyNum);
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("%s个key已经生产!",keyNum));
		return "redirect:/am/ques";
	}
	
	@RequestMapping(value="/finish",method=RequestMethod.POST)
	public String finish(@RequestParam("qtid")Long qtid,RedirectAttributes redirectAttributes){
		quesService.finish(qtid);
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("调查已经被结束!"));
		return "redirect:/am/ques";
	}
	
	@RequestMapping(value="/close",method=RequestMethod.POST)
	public String close(@RequestParam("qtid")Long qtid,RedirectAttributes redirectAttributes){
		quesService.close(qtid);
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_NAME, Message.error().message("调查已经被关闭!"));
		return "redirect:/am/ques";
	}
	
	@RequestMapping(value="/trackQtkey",method=RequestMethod.POST)
	public String trackQtkey(@RequestParam("qtkey")String qtkey,RedirectAttributes redirectAttributes){
		Long qtkeyLong=Format.parseLong(qtkey, 0L);
		TrackBean trackKey = quesFacade.trackKey(qtkeyLong);
		redirectAttributes.addFlashAttribute("trackKey",trackKey);
		return "redirect:/am/ques";
	}
}
