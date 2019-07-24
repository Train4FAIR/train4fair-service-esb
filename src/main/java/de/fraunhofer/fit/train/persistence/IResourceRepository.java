package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v1.Resources;

public interface IResourceRepository extends CrudRepository<Resources, String>, QueryByExampleExecutor<Resources> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<Resources> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<Resources> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<Resources> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<Resources> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
