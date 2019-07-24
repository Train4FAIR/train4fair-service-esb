package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "contributors")
public class Contributors {

	
	@SerializedName("contributor")
	@Expose
	private Contributor[] contributor;


	

	public Contributor[] getContributor() {
		return contributor;
	}



	public void setContributor(Contributor[] contributor) {
		this.contributor = contributor;
	}




	@Override
	public String toString() {
		return "ClassPojo [contributor = " + contributor + "]";
	}

}
