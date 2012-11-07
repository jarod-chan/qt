package cn.fyg.qt.domain.model.key;

import org.springframework.data.repository.Repository;



public interface KeyRepository  extends Repository<Key,Long>  {
	
	Key findOne(Long qtkey);
	
	Key save(Key key);
	
	
}
