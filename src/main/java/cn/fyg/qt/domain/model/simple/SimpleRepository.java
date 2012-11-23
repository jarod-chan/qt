package cn.fyg.qt.domain.model.simple;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface SimpleRepository extends Repository<Simple, Long> {
	
	List<Simple> findByQtidOrderByNoAsc(Long qtid);

}
