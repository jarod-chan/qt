package cn.fyg.qt.infrastructure.tool;

import java.util.Random;

public class Tool {
	
	private static char[] ch={'1','2','3','4','5','6','7','8','9','0'};
		
	/**
	 * 产生数字key
	 * @param num
	 * @return
	 */
	public static Long generateNumberKey(int num){
		
		Random random = new Random();
		String key="";
		key+=ch[ Math.abs(random.nextInt() % 9)];
		for (int i = 1; i < num; i++) {
			int rd = Math.abs(random.nextInt() % 10);
			key+=ch[rd];
		}
		return Long.valueOf(key);
	}
	

}
