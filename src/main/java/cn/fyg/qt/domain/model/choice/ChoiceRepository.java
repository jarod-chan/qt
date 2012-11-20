package cn.fyg.qt.domain.model.choice;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface ChoiceRepository extends Repository<Choice, Long> {
	
	List<Choice> findByQtidOrderByIdAsc(Long qtid);

}
