package cn.fyg.qt.application;

import java.util.List;

import cn.fyg.qt.domain.model.prize.Prize;

public interface PrizeService {
	
	List<Prize> findByQtid(Long qtid);

	Prize  find(Long id);
}
