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
	
	@SerializedName("providerURL")
	@Expose
	private String providerURL;
	
	@SerializedName("prefix")
	@Expose
	private String prefix;
	
	@SerializedName("suffix")
	@Expose
	private String  suffix;

	@SerializedName("resourcesUrl")
	@Expose
	private String  resourcesUrl;
	
	@SerializedName("metadataUrl")
	@Expose
	private String  metadataUrl;
	
	

	public String getResourcesUrl() {
		return resourcesUrl;
	}

	public void setResourcesUrl(String resourcesUrl) {
		this.resourcesUrl = resourcesUrl;
	}

	public String getMetadataUrl() {
		return metadataUrl;
	}

	public void setMetadataUrl(String metadataUrl) {
		this.metadataUrl = metadataUrl;
	}

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

	public String getProviderURL() {
		return providerURL;
	}

	public void setProviderURL(String providerURL) {
		this.providerURL = providerURL;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	
}
