package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "fundingreferences")
public class FundingReferences {

	
	@SerializedName("fundingReference")
	@Expose
	private FundingReference[] fundingReference;


	

	public FundingReference[] getFundingReference() {
		return fundingReference;
	}




	public void setFundingReference(FundingReference[] fundingReference) {
		this.fundingReference = fundingReference;
	}




	@Override
	public String toString() {
		return "ClassPojo [fundingReference = " + fundingReference + "]";
	}

}
