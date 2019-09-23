package de.fraunhofer.fit.train.model_v2.nodered;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@XmlRootElement
@Repository
@Document(collection = "_trainmetadatanoderednode")
public class TrainMetadataNoderedNODE extends BasicMetadataNoderedNODE {

	
	


}
