package de.fraunhofer.fit.train.model_v1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.fraunhofer.fit.train.model_v2.station.StationProfiles;

@XmlRootElement
@Repository
@Document(collection = "wagons")
public class Wagons  implements Serializable{


	private static final long serialVersionUID = -677848535075814550L;
	

	
	   @SerializedName("name")
	    @Expose
	    private String name;

	    @SerializedName("resources")
	    @Expose
	    private Resources[] resources;

	    @SerializedName("stationprofiles")
	    @Expose
	    private StationProfiles stationProfiles;


	    @SerializedName("description")
	    @Expose
	    private String description;
	    
	    
	    @SerializedName("result")
	    @Expose
	    private Result result;
	    
	    
	    
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
	     * "Occurrence: 1 Definition: All additional information that does not fit in
	     * any of the other categories. May be used for technical information. Allowed
	     * values, examples, other constraints: Free text. It is a best practice to
	     * supply a description."
	     * 
	     * @author Joao Bosco Jares MSc. (Software Engineer)
	     * @see www.jbjares.com
	     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	     *
	     */
	    public String getDescription() {
	        return description;
	    }

	    /**
	     * "Occurrence: 1 Definition: All additional information that does not fit in
	     * any of the other categories. May be used for technical information. Allowed
	     * values, examples, other constraints: Free text. It is a best practice to
	     * supply a description."
	     * 
	     * @author Joao Bosco Jares MSc. (Software Engineer)
	     * @see www.jbjares.com
	     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	     *
	     */
	    @XmlElement
	    public void setDescription(String description) {
	        this.description = description;
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
	     * "Occurrence: 1 This field aims to hold an optional name for the wagon
	     * instance."
	     * 
	     * @author Joao Bosco Jares MSc. (Software Engineer)
	     * @see www.jbjares.com
	     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * "Occurrence: 1 This field aims to hold an optional name for the wagon
	     * instance."
	     * 
	     * @author Joao Bosco Jares MSc. (Software Engineer)
	     * @see www.jbjares.com
	     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	     */
	    @XmlElement
	    public void setName(String name) {
	        this.name = name;
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
