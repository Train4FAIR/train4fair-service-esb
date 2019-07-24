package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "creators")
public class Creators {

	
	@SerializedName("creator")
	@Expose
	private Creator[] creator;



	public Creator[] getCreator() {
		return creator;
	}


	public void setCreator(Creator[] creator) {
		this.creator = creator;
	}



	@Override
	public String toString() {
		return "ClassPojo [creator = " + creator + "]";
	}

}
