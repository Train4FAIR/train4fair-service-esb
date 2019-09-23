package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v2.nodered.WagonsMetadataNoderedNODE;

public interface IWagonsRepositoryNode extends CrudRepository<WagonsMetadataNoderedNODE, String>, QueryByExampleExecutor<WagonsMetadataNoderedNODE> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<WagonsMetadataNoderedNODE> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<WagonsMetadataNoderedNODE> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '?0' : ?1}")
	List<WagonsMetadataNoderedNODE> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<WagonsMetadataNoderedNODE> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}
