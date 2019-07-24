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
@Document(collection = "alternateIdentifier")
public class AlternateIdentifier {
	
	@SerializedName("content")
	@Expose
	private String content;

	@SerializedName("alternateIdentifierType")
	@Expose
	private String alternateIdentifierType;

	public String getContent() {
		return content;
	}

	@XmlValue
	public void setContent(String content) {
		this.content = content;
	}

	public String getAlternateIdentifierType() {
		return alternateIdentifierType;
	}

	@XmlAttribute
	public void setAlternateIdentifierType(String alternateIdentifierType) {
		this.alternateIdentifierType = alternateIdentifierType;
	}

	@Override
	public String toString() {
		return "ClassPojo [content = " + content + ", alternateIdentifierType = " + alternateIdentifierType + "]";
	}

}
