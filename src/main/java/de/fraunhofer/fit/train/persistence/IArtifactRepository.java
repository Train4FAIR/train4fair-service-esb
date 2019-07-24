package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Wagons;

public interface IArtifactRepository extends CrudRepository<Artifacts, String>, QueryByExampleExecutor<Artifacts> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<Artifacts> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<Artifacts> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<Artifacts> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<Artifacts> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
