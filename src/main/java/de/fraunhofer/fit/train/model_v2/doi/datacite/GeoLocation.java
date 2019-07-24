package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GeoLocation {

	
	private GeoLocationPoint geoLocationPoint;

	private GeoLocationPolygon geoLocationPolygon;

	private String geoLocationPlace;

	private GeoLocationBox geoLocationBox;

	public GeoLocationPoint getGeoLocationPoint() {
		return geoLocationPoint;
	}

	public void setGeoLocationPoint(GeoLocationPoint geoLocationPoint) {
		this.geoLocationPoint = geoLocationPoint;
	}

	public GeoLocationPolygon getGeoLocationPolygon() {
		return geoLocationPolygon;
	}

	public void setGeoLocationPolygon(GeoLocationPolygon geoLocationPolygon) {
		this.geoLocationPolygon = geoLocationPolygon;
	}

	public String getGeoLocationPlace() {
		return geoLocationPlace;
	}

	public void setGeoLocationPlace(String geoLocationPlace) {
		this.geoLocationPlace = geoLocationPlace;
	}

	public GeoLocationBox getGeoLocationBox() {
		return geoLocationBox;
	}

	public void setGeoLocationBox(GeoLocationBox geoLocationBox) {
		this.geoLocationBox = geoLocationBox;
	}

	@Override
	public String toString() {
		return "ClassPojo [geoLocationPoint = " + geoLocationPoint + ", geoLocationPolygon = " + geoLocationPolygon
				+ ", geoLocationPlace = " + geoLocationPlace + ", geoLocationBox = " + geoLocationBox + "]";
	}

}
