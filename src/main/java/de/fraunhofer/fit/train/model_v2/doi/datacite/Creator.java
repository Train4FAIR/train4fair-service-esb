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
@Document(collection = "creator")
@XmlType(propOrder = {"creatorName","givenName","familyName","nameIdentifier","affiliation"})
public class Creator {

	
	@SerializedName("affiliation")
	@Expose
	private String affiliation;

	@SerializedName("givenName")
	@Expose
	private String givenName;

	@SerializedName("familyName")
	@Expose
	private String familyName;

	@SerializedName("creatorName")
	@Expose
	private CreatorName creatorName;

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

	@XmlElement
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public CreatorName getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(CreatorName creatorName) {
		this.creatorName = creatorName;
	}

	public NameIdentifier getNameIdentifier() {
		return nameIdentifier;
	}

	public void setNameIdentifier(NameIdentifier nameIdentifier) {
		this.nameIdentifier = nameIdentifier;
	}

	@Override
	public String toString() {
		return "ClassPojo [affiliation = " + affiliation + ", givenName = " + givenName + ", familyName = " + familyName
				+ ", creatorName = " + creatorName + ", nameIdentifier = " + nameIdentifier + "]";
	}

}
