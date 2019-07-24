package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "rightslist")
public class RightsList {

	@SerializedName("rights")
	@Expose
	private Rights[] rights;
	



	public Rights[] getRights() {
		return rights;
	}




	public void setRights(Rights[] rights) {
		this.rights = rights;
	}




	@Override
	public String toString() {
		return "ClassPojo [rights = " + rights + "]";
	}

}
