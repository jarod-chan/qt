package cn.fyg.qt.domain.model.recvlog;

public class RecvlogFactory {
	
	public static Recvlog create(Long qtid,Long centerId,Long prizeKey,Long prizeId){
		Recvlog recvlog=new Recvlog();
		recvlog.setQtid(qtid);
		recvlog.setCenterId(centerId);
		recvlog.setPrizeKey(prizeKey);
		recvlog.setPrizeId(prizeId);
		return recvlog;
	}

}
