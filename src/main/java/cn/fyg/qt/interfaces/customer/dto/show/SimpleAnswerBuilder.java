package cn.fyg.qt.interfaces.customer.dto.show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.fyg.qt.domain.model.replay.Replay;
import cn.fyg.qt.domain.model.simple.Simple;

public class SimpleAnswerBuilder {
	
	public static List<SimpleAnswer> create(List<Simple> simpleList,List<Replay> replayList){
		ArrayList<SimpleAnswer> simpleAnswerList = new ArrayList<SimpleAnswer>();
		Map<Long,Replay> replayMap=getReplayMap(replayList);
		for (Simple simple : simpleList) {
			SimpleAnswer simpleAnswer = new SimpleAnswer();
			simpleAnswer.setSimple(simple);
			Replay replay=replayMap.get(simple.getId());
			if(replay!=null){
				simpleAnswer.setId(replay.getId());
				simpleAnswer.setValue(replay.getValue());
			}
			simpleAnswerList.add(simpleAnswer);
		}
		return simpleAnswerList;
	}

	private static Map<Long, Replay> getReplayMap(List<Replay> replayList) {
		Map<Long, Replay> replayMap = new HashMap<Long,Replay>();
		for (Replay replay : replayList) {
			replayMap.put(replay.getSimpleId(), replay);
		}
		return replayMap;
	}

}
