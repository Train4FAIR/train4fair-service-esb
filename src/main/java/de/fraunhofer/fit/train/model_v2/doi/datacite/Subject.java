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
@Document(collection = "subject")
@XmlType(propOrder = {"xml","schemeURI","subjectScheme"})
public class Subject {

	
	@SerializedName("schemeURI")
	@Expose
	private String schemeURI;

	
	@SerializedName("content")
	@Expose
	private String content;

	@SerializedName("subjectScheme")
	@Expose
	private String subjectScheme;
	
	@SerializedName("xml")
	@Expose
	private String xml;
	
	

	public String getXml() {
		return xml;
	}

	@XmlAttribute(name = "lang", 
            namespace = javax.xml.XMLConstants.XML_NS_URI)
	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getSchemeURI() {
		return schemeURI;
	}

	@XmlAttribute
	public void setSchemeURI(String schemeURI) {
		this.schemeURI = schemeURI;
	}

	public String getContent() {
		return content;
	}

	@XmlValue
	public void setContent(String content) {
		this.content = content;
	}

	public String getSubjectScheme() {
		return subjectScheme;
	}

	@XmlAttribute
	public void setSubjectScheme(String subjectScheme) {
		this.subjectScheme = subjectScheme;
	}

	@Override
	public String toString() {
		return "ClassPojo [schemeURI = " + schemeURI + ", content = " + content + ", subjectScheme = " + subjectScheme
				+ "]";
	}

}
