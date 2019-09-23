package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v2.nodered.TrainMetadataNoderedNODE;

public interface ITrainRepositoryNode extends CrudRepository<TrainMetadataNoderedNODE, String>, QueryByExampleExecutor<TrainMetadataNoderedNODE> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<TrainMetadataNoderedNODE> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<TrainMetadataNoderedNODE> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<TrainMetadataNoderedNODE> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<TrainMetadataNoderedNODE> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
