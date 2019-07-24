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
	
	
	@SerializedName("stationprofile")
	@Expose
	private String[] stationProfile;
	
	
	
	public String[] getStationProfiles() {
		return stationProfile;
	}

	@XmlElement
	public void setStationProfiles(String[] stationProfile) {
		this.stationProfile = stationProfile;
	}

	
	public static void main (String args[]) {
		Gson gson = new Gson();
		String result = gson.toJson(StationProfiles.class);
		System.out.println(result);
	}

}


