package de.fraunhofer.fit.train.model_v2.station;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "stationprofiles")
public class StationProfiles {
	
	
	@SerializedName("stationProfile")
	@Expose
	private String[] stationProfile;
	
	

	public String[] getStationProfile() {
		return stationProfile;
	}

	@XmlElement
	public void setStationProfile(String[] stationProfile) {
		this.stationProfile = stationProfile;
	}
	


}


