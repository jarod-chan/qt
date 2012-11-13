package cn.fyg.qt.application.facade.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.fyg.qt.application.KeyService;
import cn.fyg.qt.application.QuesService;
import cn.fyg.qt.domain.model.key.Key;
import cn.fyg.qt.domain.model.key.KeyState;
import cn.fyg.qt.domain.model.ques.Ques;
import cn.fyg.qt.interfaces.admin.dao.QuesBean;

@Component
public class QuesFacade {
	
	@Autowired
	QuesService quesService;
	@Autowired
	KeyService keyService;
	
	public List<QuesBean> getQuesBeanList() {
		List<QuesBean> quesBeanList=new ArrayList<QuesBean>();
		List<Ques> quesList = quesService.findByQtidAsc();
		for (Ques ques : quesList) {
			QuesBean quesBean = new QuesBean();
			quesBean.setQues(ques);
			quesBean.setValidNum(keyService.countByQuesState(ques.getQtid(), KeyState.nouse,KeyState.used,KeyState.finish));
			quesBean.setFinishNum(keyService.countByQuesState(ques.getQtid(), KeyState.finish));
			quesBeanList.add(quesBean);
		}
		return quesBeanList;
	}

	@Transactional
	public void produceKey(Long qtid, int keyNum) {
		for(int i=0;i<keyNum;i++){
			Key key=keyService.create(qtid);
			keyService.save(key);
		}
	}

}
