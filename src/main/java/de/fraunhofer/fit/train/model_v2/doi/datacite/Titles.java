package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "titles")
public class Titles {

	
	@SerializedName("title")
	@Expose
	private Title[] title;

	public Title[] getTitle() {
		return title;
	}

	public void setTitle(Title[] title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ClassPojo [title = " + title + "]";
	}

}
