package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "date")
@XmlType(propOrder = {"dateType","dateInformation"} )
public class Date {
	
	@SerializedName("dateType")
	@Expose
	private String dateType;

	@SerializedName("dateInformation")
	@Expose
	private String dateInformation;

	
	@SerializedName("content")
	@Expose
	private String content;

	
	
	public String getDateType() {
		return dateType;
	}

	@XmlAttribute
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getDateInformation() {
		return dateInformation;
	}
	@XmlAttribute
	public void setDateInformation(String dateInformation) {
		this.dateInformation = dateInformation;
	}

	public String getContent() {
		return content;
	}
	@XmlValue
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ClassPojo [dateType = " + dateType + ", dateInformation = " + dateInformation + ", content = " + content
				+ "]";
	}
}
