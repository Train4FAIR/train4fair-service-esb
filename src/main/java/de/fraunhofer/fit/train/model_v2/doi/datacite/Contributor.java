package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "contributor")
@XmlType(propOrder = {"contributorType","contributorName","givenName","familyName","nameIdentifier","affiliation"})
public class Contributor {

	@SerializedName("affiliation")
	@Expose
	private String affiliation;

	@SerializedName("givenName")
	@Expose
	private String givenName;

	@SerializedName("familyName")
	@Expose
	private String familyName;

	@SerializedName("contributorType")
	@Expose
	private String contributorType;

	@SerializedName("contributorName")
	@Expose
	private String contributorName;

	@SerializedName("nameIdentifier")
	@Expose
	private NameIdentifier nameIdentifier;

	public String getAffiliation() {
		return affiliation;
	}
	@XmlElement
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getGivenName() {
		return givenName;
	}
	@XmlElement
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}
	@XmlElement
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getContributorType() {
		return contributorType;
	}

	@XmlAttribute
	public void setContributorType(String contributorType) {
		this.contributorType = contributorType;
	}

	public String getContributorName() {
		return contributorName;
	}
	@XmlElement
	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public NameIdentifier getNameIdentifier() {
		return nameIdentifier;
	}

	@XmlElement
	public void setNameIdentifier(NameIdentifier nameIdentifier) {
		this.nameIdentifier = nameIdentifier;
	}

	@Override
	public String toString() {
		return "ClassPojo [affiliation = " + affiliation + ", givenName = " + givenName + ", familyName = " + familyName
				+ ", contributorType = " + contributorType + ", contributorName = " + contributorName
				+ ", nameIdentifier = " + nameIdentifier + "]";
	}

}
