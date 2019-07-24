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
@Document(collection = "resourcetype")
public class ResourceType {

	@SerializedName("resourceTypeGeneral")
	@Expose
	private String resourceTypeGeneral;

	@SerializedName("content")
	@Expose
	private String content;

	public String getResourceTypeGeneral() {
		return resourceTypeGeneral;
	}

	@XmlAttribute
	public void setResourceTypeGeneral(String resourceTypeGeneral) {
		this.resourceTypeGeneral = resourceTypeGeneral;
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
		return "ClassPojo [resourceTypeGeneral = " + resourceTypeGeneral + ", content = " + content + "]";
	}

}
