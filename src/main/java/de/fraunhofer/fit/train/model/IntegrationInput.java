package de.fraunhofer.fit.train.model;

public class IntegrationInput {
	
	private String trainId;
	
	private String correlationId;
	
	private IntegrationInputWagon[] integrationInputWagon;

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

	public IntegrationInputWagon[] getIntegrationInputWagon() {
		return integrationInputWagon;
	}

	public void setIntegrationInputWagon(IntegrationInputWagon[] integrationInputWagon) {
		this.integrationInputWagon = integrationInputWagon;
	}
	
	

}
