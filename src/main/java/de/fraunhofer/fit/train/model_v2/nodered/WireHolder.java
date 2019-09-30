package de.fraunhofer.fit.train.model_v2.nodered;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "_wireholder")
public class WireHolder {
	
	@Id
	private ObjectId _id;
	
	
	@SerializedName("alreadyVisitedWireHolder")
	@Expose
	private String alreadyVisitedWireHolder;


	
	
	public String getAlreadyVisitedWireHolder() {
		return alreadyVisitedWireHolder;
	}

	public void setAlreadyVisitedWireHolder(String alreadyVisitedWireHolder) {
		this.alreadyVisitedWireHolder = alreadyVisitedWireHolder;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	
	
	
}
