package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v2.nodered.ArtifactsMetadataNoderedNODE;

public interface IArtifactsRepositoryNode extends CrudRepository<ArtifactsMetadataNoderedNODE, String>, QueryByExampleExecutor<ArtifactsMetadataNoderedNODE> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<ArtifactsMetadataNoderedNODE> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<ArtifactsMetadataNoderedNODE> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<ArtifactsMetadataNoderedNODE> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<ArtifactsMetadataNoderedNODE> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
