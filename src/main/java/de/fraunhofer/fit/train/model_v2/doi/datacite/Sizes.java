package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "sizes")
public class Sizes {

	@SerializedName("size")
	@Expose
	private Size[] size;



	public Size[] getSize() {
		return size;
	}



	public void setSize(Size[] size) {
		this.size = size;
	}



	@Override
	public String toString() {
		return "ClassPojo [size = " + size + "]";
	}

}
