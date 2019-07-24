package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "fundingreference")
@XmlType(propOrder = {"funderName","funderIdentifier","awardNumber","awardTitle"})
public class FundingReference {

	
	@SerializedName("funderName")
	@Expose
	private String funderName;

	@SerializedName("funderIdentifier")
	@Expose
	private FunderIdentifier funderIdentifier;

	@SerializedName("awardNumber")
	@Expose
	private String awardNumber;

	@SerializedName("awardTitle")
	@Expose
	private String awardTitle;

	public String getFunderName() {
		return funderName;
	}

	@XmlElement
	public void setFunderName(String funderName) {
		this.funderName = funderName;
	}

	public FunderIdentifier getFunderIdentifier() {
		return funderIdentifier;
	}

	@XmlElement
	public void setFunderIdentifier(FunderIdentifier funderIdentifier) {
		this.funderIdentifier = funderIdentifier;
	}

	public String getAwardNumber() {
		return awardNumber;
	}

	@XmlElement
	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}

	public String getAwardTitle() {
		return awardTitle;
	}

	@XmlElement
	public void setAwardTitle(String awardTitle) {
		this.awardTitle = awardTitle;
	}

	@Override
	public String toString() {
		return "ClassPojo [funderName = " + funderName + ", funderIdentifier = " + funderIdentifier + ", awardNumber = "
				+ awardNumber + ", awardTitle = " + awardTitle + "]";
	}

}
