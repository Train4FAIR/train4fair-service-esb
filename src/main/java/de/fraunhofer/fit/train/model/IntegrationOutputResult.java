package de.fraunhofer.fit.train.model;

public class IntegrationOutputResult {
	
	private String mimetype;
	
	private String repositoryImageId;
	
	private String description;
	
	private byte[] result;

	private String statusCode;
	
	
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getResult() {
		return result;
	}

	public void setResult(byte[] result) {
		this.result = result;
	}

	public String getRepositoryImageId() {
		return repositoryImageId;
	}

	public void setRepositoryImageId(String repositoryImageId) {
		this.repositoryImageId = repositoryImageId;
	}
	
	

}
