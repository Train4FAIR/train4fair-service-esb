package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GeoLocationPolygon {

	private PolygonPoint[] polygonPoint;

	public PolygonPoint[] getPolygonPoint() {
		return polygonPoint;
	}

	public void setPolygonPoint(PolygonPoint[] polygonPoint) {
		this.polygonPoint = polygonPoint;
	}

	@Override
	public String toString() {
		return "ClassPojo [polygonPoint = " + polygonPoint + "]";
	}

}
