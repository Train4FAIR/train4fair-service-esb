package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GeoLocations {

	private GeoLocation geoLocation;

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		return "ClassPojo [geoLocation = " + geoLocation + "]";
	}

}
