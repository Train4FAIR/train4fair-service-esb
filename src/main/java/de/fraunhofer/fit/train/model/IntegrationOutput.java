package de.fraunhofer.fit.train.model;

public class IntegrationOutput {
	
	
	private String trainId;
	
	private String correlationId;
	
	private IntegrationOutputWagon[] integrationOutputWagon;

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public IntegrationOutputWagon[] getIntegrationOutputWagon() {
		return integrationOutputWagon;
	}

	public void setIntegrationOutputWagon(IntegrationOutputWagon[] integrationOutputWagon) {
		this.integrationOutputWagon = integrationOutputWagon;
	}
	
	

}
