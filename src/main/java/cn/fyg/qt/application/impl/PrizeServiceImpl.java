package cn.fyg.qt.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fyg.qt.application.PrizeService;
import cn.fyg.qt.domain.model.prize.Prize;
import cn.fyg.qt.domain.model.prize.PrizeRepository;

@Service
public class PrizeServiceImpl implements PrizeService {
	
	@Autowired
	PrizeRepository prizeRepository;

	@Override
	public List<Prize> findByQtid(Long qtid) {
		return prizeRepository.findByQtidOrderByIdAsc(qtid);
	}

	@Override
	public Prize find(Long id) {
		return prizeRepository.findOne(id);
	}

}
