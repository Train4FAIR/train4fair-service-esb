package de.fraunhofer.fit.train.model_v2.nodered;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@XmlRootElement
@Repository
@Document(collection = "_artifactsmetadatanoderednode")
public class ArtifactsMetadataNoderedNODE extends BasicMetadataNoderedNODE {

}
