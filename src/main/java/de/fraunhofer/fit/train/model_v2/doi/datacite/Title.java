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
@Document(collection = "title")
@XmlType(propOrder = {"xml","titleType"})
public class Title {
	
	
	@SerializedName("content")
	@Expose
	private String content;
	
	@SerializedName("titleType")
	@Expose
	private String titleType;
	
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


	public String getTitleType() {
		return titleType;
	}

	@XmlAttribute
	public void setTitleType(String titleType) {
		this.titleType = titleType;
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
		return "ClassPojo [content = " + content + "]";
	}
}
