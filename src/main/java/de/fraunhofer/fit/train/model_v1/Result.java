package de.fraunhofer.fit.train.model_v1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.fraunhofer.fit.train.model_v2.core.IResult;

/**
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
@XmlRootElement
@Repository
@Document(collection = "result")
public class Result implements IResult{
	
	/**
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 */
	private static final long serialVersionUID = -3002743644441337836L;

	@SerializedName("patientCohortFor")
	@Expose
	private String patientCohortFor;
	
	@SerializedName("retrievedCohortSize")
	@Expose
	private String retrievedCohortSize;
	
	@SerializedName("cohortSizeAfterEliminatingPatientswithNOAgeData")
	@Expose
	private String cohortSizeAfterEliminatingPatientswithNOAgeData;
	
	@SerializedName("meanAgeCohortResult")
	@Expose
	private String meanAgeCohortResult;
	
	@Id
	private ObjectId _id;
	

public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
    @SerializedName("internalId")
    @Expose
	private String internalId;
    
    
	
	
    public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	@SerializedName("wagonId")
    @Expose
	private String wagonId;
    


	public String getWagonId() {
		return wagonId;
	}

	public void setWagonId(String wagonId) {
		this.wagonId = wagonId;
	}

	public String getPatientCohortFor() {
		return patientCohortFor;
	}

	@XmlElement
	public void setPatientCohortFor(String patientCohortFor) {
		this.patientCohortFor = patientCohortFor;
	}

	
	public String getRetrievedCohortSize() {
		return retrievedCohortSize;
	}

	@XmlElement
	public void setRetrievedCohortSize(String retrievedCohortSize) {
		this.retrievedCohortSize = retrievedCohortSize;
	}

	public String getCohortSizeAfterEliminatingPatientswithNOAgeData() {
		return cohortSizeAfterEliminatingPatientswithNOAgeData;
	}

	@XmlElement
	public void setCohortSizeAfterEliminatingPatientswithNOAgeData(String cohortSizeAfterEliminatingPatientswithNOAgeData) {
		this.cohortSizeAfterEliminatingPatientswithNOAgeData = cohortSizeAfterEliminatingPatientswithNOAgeData;
	}

	public String getMeanAgeCohortResult() {
		return meanAgeCohortResult;
	}

	@XmlElement
	public void setMeanAgeCohortResult(String meanAgeCohortResult) {
		this.meanAgeCohortResult = meanAgeCohortResult;
	}
	
	
	
	

}
