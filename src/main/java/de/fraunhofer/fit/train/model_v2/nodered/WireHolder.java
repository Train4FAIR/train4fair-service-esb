package de.fraunhofer.fit.train.model_v2.nodered;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "wireHolder")
public class WireHolder {
	
	
	@SerializedName("wireIndex")
	@Expose
	private String wireIndex;
	
	
	@SerializedName("trainObjectId")
	@Expose
	private String trainObjectId;


	public String getWireIndex() {
		return wireIndex;
	}


	public void setWireIndex(String wireIndex) {
		this.wireIndex = wireIndex;
	}


	public String getTrainObjectId() {
		return trainObjectId;
	}


	public void setTrainObjectId(String trainObjectId) {
		this.trainObjectId = trainObjectId;
	}
	
	

}
