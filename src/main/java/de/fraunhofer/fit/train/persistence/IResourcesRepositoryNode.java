package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v2.nodered.ResourcesMetadataNoderedNODE;

public interface IResourcesRepositoryNode extends CrudRepository<ResourcesMetadataNoderedNODE, String>, QueryByExampleExecutor<ResourcesMetadataNoderedNODE> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<ResourcesMetadataNoderedNODE> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<ResourcesMetadataNoderedNODE> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<ResourcesMetadataNoderedNODE> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<ResourcesMetadataNoderedNODE> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
