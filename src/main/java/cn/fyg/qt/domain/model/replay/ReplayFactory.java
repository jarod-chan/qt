package cn.fyg.qt.domain.model.replay;

public class ReplayFactory {
	
	public static Replay create(Long qtid,Long qtkey){
		Replay replay=new Replay();
		replay.setQtid(qtid);
		replay.setQtkey(qtkey);
		return replay;
	}

}
