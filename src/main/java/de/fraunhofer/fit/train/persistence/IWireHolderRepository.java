package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v2.nodered.WireHolder;

public interface IWireHolderRepository extends CrudRepository<WireHolder, String>, QueryByExampleExecutor<WireHolder> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<WireHolder> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<WireHolder> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<WireHolder> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<WireHolder> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
