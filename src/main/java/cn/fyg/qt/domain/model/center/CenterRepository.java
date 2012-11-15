package cn.fyg.qt.domain.model.center;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CenterRepository extends Repository<Center, Long> {
	
	Center findOne(Long id);
	
	Center save(Center center);
	
	Center findByIdname(String idname);

	List<Center> findByQtidOrderByIdAsc(Long qtid);

}
