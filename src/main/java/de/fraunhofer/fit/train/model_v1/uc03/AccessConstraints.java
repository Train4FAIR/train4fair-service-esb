package de.fraunhofer.fit.train.model_v1.uc03;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "accessConstraints")
public class AccessConstraints {
	
	@SerializedName("patientRegistry")
	@Expose
	private String patientRegistry;
	
	@SerializedName("severity")
	@Expose
	private String severity;
	
	@SerializedName("rareDisease")
	@Expose
	private Boolean rareDisease ;
	
	@SerializedName("treatmentCenter")
	@Expose
	private Boolean treatmentCenter ;

	@SerializedName("restrictionsOnPersonalData")
	@Expose
	private Boolean restrictionsOnPersonalData;

	public String getPatientRegistry() {
		return patientRegistry;
	}

	public void setPatientRegistry(String patientRegistry) {
		this.patientRegistry = patientRegistry;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Boolean getRareDisease() {
		return rareDisease;
	}

	public void setRareDisease(Boolean rareDisease) {
		this.rareDisease = rareDisease;
	}

	public Boolean getTreatmentCenter() {
		return treatmentCenter;
	}

	public void setTreatmentCenter(Boolean treatmentCenter) {
		this.treatmentCenter = treatmentCenter;
	}

	public Boolean getRestrictionsOnPersonalData() {
		return restrictionsOnPersonalData;
	}

	public void setRestrictionsOnPersonalData(Boolean restrictionsOnPersonalData) {
		this.restrictionsOnPersonalData = restrictionsOnPersonalData;
	}
	
	
	
}
