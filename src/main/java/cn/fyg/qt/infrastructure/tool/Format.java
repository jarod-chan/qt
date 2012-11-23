package cn.fyg.qt.infrastructure.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
	
	public static Long parseLong(String longStr,Long defaultValue){
		Long targetValue=defaultValue;
		try{
			targetValue=Long.parseLong(longStr.replaceAll("\\s*", "")); //替换掉所有空白字符，\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个  
		}catch(Exception e){
		}
		return targetValue;
	}

	public static String formatDate(Date date){
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return dateFormat.format(date);
	}
}
