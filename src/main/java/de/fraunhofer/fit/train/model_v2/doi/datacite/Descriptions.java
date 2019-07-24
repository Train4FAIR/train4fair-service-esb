package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "descriptions")
public class Descriptions {

	
	@SerializedName("description")
	@Expose
	private Description[] description;


	
	
	public Description[] getDescription() {
		return description;
	}




	public void setDescription(Description[] description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "ClassPojo [description = " + description + "]";
	}

}
