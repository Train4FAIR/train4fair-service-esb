package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "identifier")
public class Identifier {


	@SerializedName("identifierType")
	@Expose
	private String identifierType;

	@SerializedName("content")
	@Expose
	private String content;

	public String getIdentifierType() {
		return identifierType;
	}

	@XmlAttribute
	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
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
		return "ClassPojo [identifierType = " + identifierType + ", content = " + content + "]";
	}

}
