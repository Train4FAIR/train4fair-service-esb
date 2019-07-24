package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "alternateIdentifiers")
public class AlternateIdentifiers {

	
	@SerializedName("alternateIdentifier")
	@Expose
	private AlternateIdentifier[]  alternateIdentifier;



	public AlternateIdentifier[] getAlternateIdentifier() {
		return alternateIdentifier;
	}



	public void setAlternateIdentifier(AlternateIdentifier[] alternateIdentifier) {
		this.alternateIdentifier = alternateIdentifier;
	}



	@Override
	public String toString() {
		return "ClassPojo [alternateIdentifier = " + alternateIdentifier + "]";
	}

}
