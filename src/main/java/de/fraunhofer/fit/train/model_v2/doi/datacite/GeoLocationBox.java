package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GeoLocationBox {

	private String northBoundLatitude;

	private String southBoundLatitude;

	private String westBoundLongitude;

	private String eastBoundLongitude;

	public String getNorthBoundLatitude() {
		return northBoundLatitude;
	}

	public void setNorthBoundLatitude(String northBoundLatitude) {
		this.northBoundLatitude = northBoundLatitude;
	}

	public String getSouthBoundLatitude() {
		return southBoundLatitude;
	}

	public void setSouthBoundLatitude(String southBoundLatitude) {
		this.southBoundLatitude = southBoundLatitude;
	}

	public String getWestBoundLongitude() {
		return westBoundLongitude;
	}

	public void setWestBoundLongitude(String westBoundLongitude) {
		this.westBoundLongitude = westBoundLongitude;
	}

	public String getEastBoundLongitude() {
		return eastBoundLongitude;
	}

	public void setEastBoundLongitude(String eastBoundLongitude) {
		this.eastBoundLongitude = eastBoundLongitude;
	}

	@Override
	public String toString() {
		return "ClassPojo [northBoundLatitude = " + northBoundLatitude + ", southBoundLatitude = " + southBoundLatitude
				+ ", westBoundLongitude = " + westBoundLongitude + ", eastBoundLongitude = " + eastBoundLongitude + "]";
	}

}
