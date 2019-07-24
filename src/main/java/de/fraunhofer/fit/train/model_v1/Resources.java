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

import de.fraunhofer.fit.train.model_v1.oci.OCI;


@XmlRootElement
@Repository
@Document(collection = "resources")
public class Resources implements Serializable{
	
private static final long serialVersionUID = 5562880948241337153L;

	
	@SerializedName("name")
    @Expose
    private String name;

    @SerializedName("artifacts")
    @Expose
    private Artifacts[] artifacts;


    @SerializedName("oci")
    @Expose
    private OCI oci;

    
    @SerializedName("description")
    @Expose
    private String description;
    
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
     * "Note: Any OPTIONAL field MAY also be set to null, which is equivalent to
     * being absent. Any extra fields in the Image JSON struct are considered
     * implementation specific and MUST be ignored by any implementations which are
     * unable to interpret them.
     * 
     * Whitespace is OPTIONAL and implementations MAY have compact JSON with no
     * whitespace."
     * 
     * @author Joao Bosco Jares MSc. (Software Engineer)
     * @see www.jbjares.com
     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
     *
     */
    public OCI getOci() {
        return oci;
    }

    /**
     * "Note: Any OPTIONAL field MAY also be set to null, which is equivalent to
     * being absent. Any extra fields in the Image JSON struct are considered
     * implementation specific and MUST be ignored by any implementations which are
     * unable to interpret them.
     * 
     * Whitespace is OPTIONAL and implementations MAY have compact JSON with no
     * whitespace."
     * 
     * @author Joao Bosco Jares MSc. (Software Engineer)
     * @see www.jbjares.com
     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
     *
     */
    @XmlElement
    public void setOci(OCI oci) {
        this.oci = oci;
    }

    /**
     * "Occurrence: 1 Could be one or one array of this object. This object aims to
     * hold the metadata of the objects which usssually as part of the data model,
     * (Like Pyhton/Java/Ruby scripts, idependent of the language or version, just
     * should be in counpliance with the OCI specipication). All this information
     * should cover necessary information, by the Resource node/profile to be
     * present as an properly mentadadata artifact on the Train Model execution
     * diagram. The Resource object could be represented as an list as well the
     * Appelication service profile of each use case could be extensible, depende of
     * the requiprements. "
     * 
     * @author Joao Bosco Jares MSc. (Software Engineer)
     * @see www.jbjares.com
     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
     *
     */
    public Artifacts[] getArtifacts() {
        return artifacts;
    }

    /**
     * "Occurrence: 1 Could be one or one array of this object. This object aims to
     * hold the metadata of the objects which usssually as part of the data model,
     * (Like Pyhton/Java/Ruby scripts, idependent of the language or version, just
     * should be in counpliance with the OCI specipication). All this information
     * should cover necessary information, by the Resource node/profile to be
     * present as an properly mentadadata artifact on the Train Model execution
     * diagram. The Resource object could be represented as an list as well the
     * Appelication service profile of each use case could be extensible, depende of
     * the requiprements. "
     * 
     * @author Joao Bosco Jares MSc. (Software Engineer)
     * @see www.jbjares.com
     * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
     *
     */
    @XmlElement
    public void setArtifacts(Artifacts[] artifacts) {
        this.artifacts = artifacts;
    }


	
	
	

}
