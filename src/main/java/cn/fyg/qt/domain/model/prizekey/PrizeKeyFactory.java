package cn.fyg.qt.domain.model.prizekey;

import cn.fyg.qt.infrastructure.tool.Tool;

public class PrizeKeyFactory {
	
	public static PrizeKey create(Long qtid){
		PrizeKey prizeKeyObject=new PrizeKey();
		prizeKeyObject.setPrizeKey(Tool.generateNumberKey(8));
		prizeKeyObject.setQtid(qtid);
		prizeKeyObject.setPrizeState(PrizeState.nouse);
		return prizeKeyObject;
	}

}
