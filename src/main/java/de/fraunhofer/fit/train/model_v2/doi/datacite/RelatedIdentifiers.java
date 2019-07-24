package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "relatedidentifiers")
public class RelatedIdentifiers {

	
	@SerializedName("relatedIdentifier")
	@Expose
	private RelatedIdentifier[] relatedIdentifier;

	public RelatedIdentifier[] getRelatedIdentifier() {
		return relatedIdentifier;
	}

	public void setRelatedIdentifier(RelatedIdentifier[] relatedIdentifier) {
		this.relatedIdentifier = relatedIdentifier;
	}

	@Override
	public String toString() {
		return "ClassPojo [relatedIdentifier = " + relatedIdentifier + "]";
	}

}
