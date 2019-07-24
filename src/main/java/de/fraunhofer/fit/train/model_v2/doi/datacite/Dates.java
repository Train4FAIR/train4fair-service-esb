package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "dates")
public class Dates {
	
	@SerializedName("date")
	@Expose
	private Date[] date;


	

	public Date[] getDate() {
		return date;
	}



	public void setDate(Date[] date) {
		this.date = date;
	}




	@Override
	public String toString() {
		return "ClassPojo [date = " + date + "]";
	}
}
