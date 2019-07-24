package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "formats")
public class Formats {

	
	@SerializedName("format")
	@Expose
	private Format[] format;

	public Format[] getFormat() {
		return format;
	}

	public void setFormat(Format[] format) {
		this.format = format;
	}



}
