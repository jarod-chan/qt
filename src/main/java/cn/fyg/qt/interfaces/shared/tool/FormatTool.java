package cn.fyg.qt.interfaces.shared.tool;

public class FormatTool {
	
	public static Long parseLong(String longStr,Long defaultValue){
		Long targetValue=defaultValue;
		try{
			targetValue=Long.parseLong(longStr.replaceAll("\\s*", "")); //替换掉所有空白字符，\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个  
		}catch(Exception e){
		}
		return targetValue;
	}

}
