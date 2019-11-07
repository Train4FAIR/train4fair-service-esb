package de.fraunhofer.fit.train.model;

public class IntegrationInputWagon {
	
	private String wagonId;
	
	private String[] stations;
	
	private String[] artifacts;
	
	private IntegrationInputProperties[] properties;

	public String getWagonId() {
		return wagonId;
	}

	public void setWagonId(String wagonId) {
		this.wagonId = wagonId;
	}

	public String[] getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(String[] artifacts) {
		this.artifacts = artifacts;
	}

	public IntegrationInputProperties[] getProperties() {
		return properties;
	}

	public void setProperties(IntegrationInputProperties[] properties) {
		this.properties = properties;
	}

	public String[] getStations() {
		return stations;
	}

	public void setStations(String[] stations) {
		this.stations = stations;
	}
	
	

}
