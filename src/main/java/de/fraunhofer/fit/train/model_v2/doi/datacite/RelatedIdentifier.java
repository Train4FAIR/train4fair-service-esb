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
@Document(collection = "relatedidentifier")
@XmlType(propOrder = {"relatedIdentifierType","relationType","relatedMetadataScheme","schemeURI","resourceTypeGeneral"})
public class RelatedIdentifier {

	@SerializedName("relationType")
	@Expose
	private String relationType;

	@SerializedName("schemeURI")
	@Expose
	private String schemeURI;

	@SerializedName("relatedIdentifierType")
	@Expose
	private String relatedIdentifierType;

	@SerializedName("content")
	@Expose
	private String content;

	@SerializedName("relatedMetadataScheme")
	@Expose
	private String relatedMetadataScheme;
	
	@SerializedName("resourceTypeGeneral")
	@Expose
	private String resourceTypeGeneral;
	
	

	public String getResourceTypeGeneral() {
		return resourceTypeGeneral;
	}

	@XmlAttribute
	public void setResourceTypeGeneral(String resourceTypeGeneral) {
		this.resourceTypeGeneral = resourceTypeGeneral;
	}

	public String getRelationType() {
		return relationType;
	}

	@XmlAttribute
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getSchemeURI() {
		return schemeURI;
	}

	@XmlAttribute
	public void setSchemeURI(String schemeURI) {
		this.schemeURI = schemeURI;
	}

	public String getRelatedIdentifierType() {
		return relatedIdentifierType;
	}

	@XmlAttribute
	public void setRelatedIdentifierType(String relatedIdentifierType) {
		this.relatedIdentifierType = relatedIdentifierType;
	}

	public String getContent() {
		return content;
	}

	@XmlValue
	public void setContent(String content) {
		this.content = content;
	}

	public String getRelatedMetadataScheme() {
		return relatedMetadataScheme;
	}

	@XmlAttribute
	public void setRelatedMetadataScheme(String relatedMetadataScheme) {
		this.relatedMetadataScheme = relatedMetadataScheme;
	}

	@Override
	public String toString() {
		return "ClassPojo [relationType = " + relationType + ", schemeURI = " + schemeURI + ", relatedIdentifierType = "
				+ relatedIdentifierType + ", content = " + content + ", relatedMetadataScheme = "
				+ relatedMetadataScheme + "]";
	}

}
