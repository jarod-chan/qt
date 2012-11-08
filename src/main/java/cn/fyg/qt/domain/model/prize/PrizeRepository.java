package cn.fyg.qt.domain.model.prize;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PrizeRepository extends Repository<Prize, Long> {
	
	List<Prize> findByQtidOrderByIdAsc(Long qtid);
	
	Prize findOne(Long id);

}
