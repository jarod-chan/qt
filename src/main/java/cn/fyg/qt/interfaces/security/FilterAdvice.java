package cn.fyg.qt.interfaces.security;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.fyg.qt.interfaces.shared.Constant.Constant;

@Component
public class FilterAdvice  {
	
	private static final List<String> noFilterClass=Arrays.asList(
			"cn.fyg.qt.interfaces.customer.VerifyCtl",
			"cn.fyg.qt.interfaces.center.LoginCtl",
			"cn.fyg.qt.interfaces.admin.AdminCtl");
	
	@Autowired
	HttpSession httpSession;
    
    
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
    	Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
    	logger.info(pjp.getSignature().getName()); 
    	
    	String className=pjp.getTarget().getClass().getName();
    	
    	if(noFilterClass.contains(className)){
    		return pjp.proceed();
    	}
    	
    	Object obj = httpSession.getAttribute(Constant.AUTH);
    	boolean isAuth=(obj==null?false:(Boolean)obj);
    	
    	if(isAuth){
    		Object retVal = pjp.proceed();
    		return retVal;
    	}
    	
    	if(className.indexOf("cn.fyg.qt.interfaces.admin")>=0){
    		return "redirect:/am";
    	}
    	if(className.indexOf("cn.fyg.qt.interfaces.center")>=0){
    		return "redirect:/ct";
    	}
    	return "redirect:/verify";
      }
    
}