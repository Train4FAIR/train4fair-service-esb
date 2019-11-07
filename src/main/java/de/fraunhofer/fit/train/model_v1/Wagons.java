package de.fraunhofer.fit.train.model_v1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.fraunhofer.fit.train.model_v1.uc03.AccessConstraints;
import de.fraunhofer.fit.train.model_v2.station.StationProfiles;

@XmlRootElement
@Repository
@Document(collection = "wagons")
public class Wagons  extends TrainAbstract implements Serializable {

	private static final long serialVersionUID = -677848535075814550L;


	@SerializedName("resources")
	@Expose
	private Resources[] resources;

	@SerializedName("stationProfiles")
	@Expose
	private StationProfiles stationProfiles;

	@SerializedName("internalWagonId")
	@Expose
	private String internalWagonId;
	
	
	
	public String getInternalWagonId() {
		return internalWagonId;
	}

	public void setInternalWagonId(String internalWagonId) {
		this.internalWagonId = internalWagonId;
	}

	/**
	 * Result object
	 */
	//TODO refactoring to be flexible for all use cases
	@SerializedName("result")
	@Expose
	private Result result;


	/**
	 * UC03 - Init
	 */

	@SerializedName("checkMetadataAccess")
	@Expose
	private Boolean checkMetadataAccess;
	
	@SerializedName("checkGeneralRegistryPolicy")
	@Expose
	private Boolean checkGeneralRegistryPolicy;
	
	@SerializedName("expectedTimePointsForAllpatientsFrom")
	@Expose
	private String expectedTimePointsForAllpatientsFrom;
	
	@SerializedName("expectedTimePointsForAllpatientsTo")
	@Expose
	private String expectedTimePointsForAllpatientsTo;
	
	@SerializedName("cutValue")
	@Expose
	private String cutValue;
	
	@SerializedName("shouldBeAggregated")
	@Expose
	private Boolean shouldBeAggregated;
	
	@SerializedName("accessConstraints")
	@Expose
	private AccessConstraints accessConstraints;
	
	
	

	public Boolean getCheckMetadataAccess() {
		return checkMetadataAccess;
	}

	public void setCheckMetadataAccess(Boolean checkMetadataAccess) {
		this.checkMetadataAccess = checkMetadataAccess;
	}

	public Boolean getCheckGeneralRegistryPolicy() {
		return checkGeneralRegistryPolicy;
	}

	public void setCheckGeneralRegistryPolicy(Boolean checkGeneralRegistryPolicy) {
		this.checkGeneralRegistryPolicy = checkGeneralRegistryPolicy;
	}

	public String getExpectedTimePointsForAllpatientsFrom() {
		return expectedTimePointsForAllpatientsFrom;
	}

	public void setExpectedTimePointsForAllpatientsFrom(String expectedTimePointsForAllpatientsFrom) {
		this.expectedTimePointsForAllpatientsFrom = expectedTimePointsForAllpatientsFrom;
	}

	public String getExpectedTimePointsForAllpatientsTo() {
		return expectedTimePointsForAllpatientsTo;
	}

	public void setExpectedTimePointsForAllpatientsTo(String expectedTimePointsForAllpatientsTo) {
		this.expectedTimePointsForAllpatientsTo = expectedTimePointsForAllpatientsTo;
	}

	public String getCutValue() {
		return cutValue;
	}

	public void setCutValue(String cutValue) {
		this.cutValue = cutValue;
	}

	public Boolean getShouldBeAggregated() {
		return shouldBeAggregated;
	}

	public void setShouldBeAggregated(Boolean shouldBeAggregated) {
		this.shouldBeAggregated = shouldBeAggregated;
	}

	public AccessConstraints getAccessConstraints() {
		return accessConstraints;
	}

	public void setAccessConstraints(AccessConstraints accessConstraints) {
		this.accessConstraints = accessConstraints;
	}

	/**
	 * UC03 - End
	 */


	@SerializedName("trainId")
	@Expose
	private String trainId;

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	/**
	 * 
	 * Holds the result after the shippment of the Train
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */

	public Result getResult() {
		return result;
	}

	/**
	 * 
	 * Holds the result after the shippment of the Train
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setResult(Result result) {
		this.result = result;
	}


	/**
	 * "Occurrence: 1 - n The stationProfiles aims to hold the logic domain name
	 * regarding each station, such as Hepatitis, Cancer, Obesity, Diabetes etc…"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public StationProfiles getStationProfiles() {
		return stationProfiles;
	}

	/**
	 * "Occurrence: 1 - n The stationProfiles aims to hold the logic domain name
	 * regarding each station, such as Hepatitis, Cancer, Obesity, Diabetes etc…"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setStationProfiles(StationProfiles stationProfiles) {
		this.stationProfiles = stationProfiles;
	}


	/**
	 * "Occurrence: 1 An array of resource objects."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public Resources[] getResources() {
		return resources;
	}

	/**
	 * "Occurrence: 1 An array of resource objects."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setResources(Resources[] resources) {
		this.resources = resources;
	}

}
