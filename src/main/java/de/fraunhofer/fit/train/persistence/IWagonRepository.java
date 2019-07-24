package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v1.Wagons;

public interface IWagonRepository extends CrudRepository<Wagons, String>, QueryByExampleExecutor<Wagons> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<Wagons> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<Wagons> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<Wagons> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<Wagons> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
