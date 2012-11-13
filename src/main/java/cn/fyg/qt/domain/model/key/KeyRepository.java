package cn.fyg.qt.domain.model.key;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;



public interface KeyRepository  extends Repository<Key,Long>  {
	
	Key findOne(Long qtkey);
	
	Key save(Key key);
	
	@Query("select count(k) from Key k where k.qtid=:qtid and k.state in(:keyState)")
	Long countByKeyState(@Param("qtid")Long qtid,@Param("keyState")List<KeyState> keyState);
	
}
