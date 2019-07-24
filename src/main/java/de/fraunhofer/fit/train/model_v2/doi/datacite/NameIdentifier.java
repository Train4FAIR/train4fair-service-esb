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
@Document(collection = "nameidentifier")
@XmlType(propOrder = {"schemeURI","nameIdentifierScheme"})
public class NameIdentifier {
	
	@SerializedName("nameIdentifierScheme")
	@Expose
	private String nameIdentifierScheme;

	@SerializedName("schemeURI")
	@Expose
	private String schemeURI;

	@SerializedName("content")
	@Expose
	private String content;

	public String getNameIdentifierScheme() {
		return nameIdentifierScheme;
	}

	@XmlAttribute
	public void setNameIdentifierScheme(String nameIdentifierScheme) {
		this.nameIdentifierScheme = nameIdentifierScheme;
	}

	public String getSchemeURI() {
		return schemeURI;
	}

	@XmlAttribute
	public void setSchemeURI(String schemeURI) {
		this.schemeURI = schemeURI;
	}

	@XmlValue
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ClassPojo [nameIdentifierScheme = " + nameIdentifierScheme + ", schemeURI = " + schemeURI
				+ ", content = " + content + "]";
	}
}
