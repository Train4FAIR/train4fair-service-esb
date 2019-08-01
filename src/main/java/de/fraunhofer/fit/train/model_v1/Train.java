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

import de.fraunhofer.fit.train.model_v2.doi.datacite.Datacite;
import de.fraunhofer.fit.train.model_v2.nodered.Flow;

/**
 * "Train - Introduction: The Train itself is piece of software, or a group of
 * combined metadata. In this use case defined by a linked of metadata objects,
 * such as the Train Object (which acts as a kind of super object, defining the
 * basic attributes to convert each new new Train as an DIgital Object by
 * default), followed by the Wagon (In this use case the wagon aims to hold the
 * metadata to drive the PHT BMI processment properly along one or more
 * stations). After the Wagon we can find the Resource module, another group of
 * metadata which aims to be the resource/files orchestrator, dealing with with
 * containerization, and more features, if necessary. Finally, we can find
 * linked to the Resource object, the Artifact object. This object aims to hold
 * the concrete file metadata, such as the name, content, type, etc. Used to
 * deal with the concrete objects.
 * 
 * Ps.: 1) Well defined standards are used to achieve features. For instance, to
 * achieve the DOI we are using the metadata defined by the Datacite
 * Specification, as well as to deal with the Containerizarion we are using the
 * OCI standard.
 * 
 * 2) The Train Specification was created to me extensible enough to express
 * specific puposes of an software/model (regarding their requirements) as
 * metadata. However, in the other side there's the application server which
 * should be aligned with each new feature/profile. "
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 */

@XmlRootElement
@Repository
@Document(collection = "train")
public class Train implements  Serializable {

	private static final long serialVersionUID = -1174834373802441278L;

	@Id
	private ObjectId _id;
	

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("internalId")
	@Expose
	private String internalId;

	@SerializedName("internalVersion")
	@Expose
	private String internalVersion;

	@SerializedName("internalPointer")
	@Expose
	private String internalPointer;

	@SerializedName("similarProjects")
	@Expose
	private String[] similarProjects;

	@SerializedName("wagons")
	@Expose
	private Wagons[] wagons;

	@SerializedName("checksum")
	@Expose
	private String checksum;

	@SerializedName("flow")
	@Expose
	private Flow flow;

	@SerializedName("sourceRepository")
	@Expose
	private String sourceRepository;

	@SerializedName("userToken")
	@Expose
	private String userToken;
	
	@SerializedName("description")
	@Expose
	private String description;
	
	
	@SerializedName("datacite")
	@Expose
	private Datacite datacite;
	

	

	
	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
	


	public Datacite getDatacite() {
		return datacite;
	}


	public void setDatacite(Datacite datacite) {
		this.datacite = datacite;
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
	 * "Occurrence: 1 The similarProjects field is autogenerated by the Train DOI
	 * Repository profile. This field is important for the kernel, once it aims to
	 * be the holder of the relationship between the different parts of one or more
	 * Train parts as well as the related representations on the Repository, based
	 * on the standard Train DOI Repository Algoriihms."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String[] getSimilarProjects() {
		return similarProjects;
	}

	/**
	 * "Occurrence: 1 The similarProjects field is autogenerated by the Train DOI
	 * Repository profile. This field is important for the kernel, once it aims to
	 * be the holder of the relationship between the different parts of one or more
	 * Train parts as well as the related representations on the Repository, based
	 * on the standard Train DOI Repository Algoriihms."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setSimilarProjects(String[] similarProjects) {
		this.similarProjects = similarProjects;
	}

	/**
	 * "Occurrence: 1 The sourceRepository field aims to be the holder of the
	 * information regarding the source repository where ths Train was persisted for
	 * the first time. That information is represented for a nine position of an
	 * alphanumeric hash. The main goal of this field is to avoid conflict between
	 * Trains which possible could transit between diferents repositories. Based on
	 * that, to provide the related disambiguation process the Digital Object
	 * Repository do the avaliation of the three fields/attributes (internalId,
	 * internalVersion as well as the sourceRepository), the algorith uses thoses
	 * these fields as a ""composed key"" to achieve the goal of the disambiguation
	 * process."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getSourceRepository() {
		return sourceRepository;
	}

	/**
	 * "Occurrence: 1 The sourceRepository field aims to be the holder of the
	 * information regarding the source repository where ths Train was persisted for
	 * the first time. That information is represented for a nine position of an
	 * alphanumeric hash. The main goal of this field is to avoid conflict between
	 * Trains which possible could transit between diferents repositories. Based on
	 * that, to provide the related disambiguation process the Digital Object
	 * Repository do the avaliation of the three fields/attributes (internalId,
	 * internalVersion as well as the sourceRepository), the algorith uses thoses
	 * these fields as a ""composed key"" to achieve the goal of the disambiguation
	 * process."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setSourceRepository(String sourceRepository) {
		this.sourceRepository = sourceRepository;
	}



	/**
	 * "Occurrence: 1 The internalId field is autogenerated by the Train DOI
	 * Repository profile. This field is important for the kernel, once it aims to
	 * be the holder of the internal identifier which is used to reforce the
	 * relations and linkage between the Wagon and other objects together the DOI or
	 * to mimic the DOI till could be retrieved."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getInternalId() {
		return internalId;
	}

	/**
	 * "Occurrence: 1 The internalId field is autogenerated by the Train DOI
	 * Repository profile. This field is important for the kernel, once it aims to
	 * be the holder of the internal identifier which is used to reforce the
	 * relations and linkage between the Wagon and other objects together the DOI or
	 * to mimic the DOI till could be retrieved."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	/**
	 * "Occurrence: 1 The internalVersion field is autogenerated by the Train DOI
	 * Repository profile. This field is important for the kernel, once it aims to
	 * be the holder of the internal version. This field is useful to validade and
	 * correlate versions from different instances or organizations."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getInternalVersion() {
		return internalVersion;
	}

	/**
	 * "Occurrence: 1 The internalVersion field is autogenerated by the Train DOI
	 * Repository profile. This field is important for the kernel, once it aims to
	 * be the holder of the internal version. This field is useful to validade and
	 * correlate versions from different instances or organizations."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setInternalVersion(String internalVersion) {
		this.internalVersion = internalVersion;
	}

	/**
	 * "Occurrence: 1 The Train internal pointer is an field which aims to hold the
	 * ""composed key"" defined by the internalId, internalVersion and
	 * sourceRepository. This field is used to facilitate the navigation between
	 * Trains distributed along of heterogeneous repositories or Handles. This
	 * attribute could be used as an URL rewriting parameter to find a specific
	 * train as well as his resources/files under the webdav, once for each new
	 * train a new folder on the webdav should be created, named by the
	 * internalPointer, which is a way of desanbiguation, not just for the Train,
	 * but for his dependencies (resources/files which are part of a single model) "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getInternalPointer() {
		return internalPointer;
	}

	/**
	 * "Occurrence: 1 The Train internal pointer is an field which aims to hold the
	 * ""composed key"" defined by the internalId, internalVersion and
	 * sourceRepository. This field is used to facilitate the navigation between
	 * Trains distributed along of heterogeneous repositories or Handles. This
	 * attribute could be used as an URL rewriting parameter to find a specific
	 * train as well as his resources/files under the webdav, once for each new
	 * train a new folder on the webdav should be created, named by the
	 * internalPointer, which is a way of desanbiguation, not just for the Train,
	 * but for his dependencies (resources/files which are part of a single model) "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setInternalPointer(String internalPointer) {
		this.internalPointer = internalPointer;
	}

	/**
	 * "Occurrence: 1 - n The Wagon field is a list. This list aims to hold the one
	 * or more wagons, where each one could be related to another Wagon or usually
	 * related to one Resource Object. The Wagon is a high level of one profile (or
	 * Node). The profile is peace of software expressed as a group of metadata
	 * (based on proposed Specification) which aims to hold the information to be
	 * processed by the Train Application Server. Based on that, we can configure
	 * and align different kind of Wagon to be properly processed for that profile
	 * (a special group or a single microservice, properly developed to deal with
	 * each new custom created Wagon). Each Train model hold (at least) one Wagon
	 * which is has the metadata to describe information such as the station
	 * profiles, or the group of stations which a group of Resources (Files), which
	 * together could retrieve the properly information from one ore a group of
	 * stations."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public Wagons[] getWagons() {
		return wagons;
	}

	/**
	 * "Occurrence: 1 - n The Wagon field is a list. This list aims to hold the one
	 * or more wagons, where each one could be related to another Wagon or usually
	 * related to one Resource Object. The Wagon is a high level of one profile (or
	 * Node). The profile is peace of software expressed as a group of metadata
	 * (based on proposed Specification) which aims to hold the information to be
	 * processed by the Train Application Server. Based on that, we can configure
	 * and align different kind of Wagon to be properly processed for that profile
	 * (a special group or a single microservice, properly developed to deal with
	 * each new custom created Wagon). Each Train model hold (at least) one Wagon
	 * which is has the metadata to describe information such as the station
	 * profiles, or the group of stations which a group of Resources (Files), which
	 * together could retrieve the properly information from one ore a group of
	 * stations."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setWagons(Wagons[] wagons) {
		this.wagons = wagons;
	}

	/**
	 * "Occurrence: 1 The checksum is an auto-genereted field which aims to be the
	 * holder of the MD5 hash, used to validate the integrity of the snapshot of the
	 * Train, before the his persistence into the Train Repositoory."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getChecksum() {
		return checksum;
	}

	/**
	 * "Occurrence: 1 The checksum is an auto-genereted field which aims to be the
	 * holder of the MD5 hash, used to validate the integrity of the snapshot of the
	 * Train, before the his persistence into the Train Repositoory."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/**
	 * "Occurrence: 1 The flow object aims to hold the attributes related to the
	 * node-red metadata. Likewise, the values holded by these attributes are used
	 * by the Train Digital Repository to launch the Train Modelling tool as well as
	 * to plot the related flow on the screen to improve the intercomunication,
	 * between other Repositories or Handles with the specific environment where the
	 * Train metadata could be shown properly, as well as encoranging the reuse,
	 * interoperability and testability, by the cientific community. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public Flow getFlow() {
		return flow;
	}

	/**
	 * "Occurrence: 1 The flow object aims to hold the attributes related to the
	 * node-red metadata. Likewise, the values holded by these attributes are used
	 * by the Train Digital Repository to launch the Train Modelling tool as well as
	 * to plot the related flow on the screen to improve the intercomunication,
	 * between other Repositories or Handles with the specific environment where the
	 * Train metadata could be shown properly, as well as encoranging the reuse,
	 * interoperability and testability, by the cientific community. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	/**
	 * "Ocurrence:1 This field is auto completed with the userToken of the
	 * athenticated user, or if the user are trying to test the platform as a Guest
	 * one token should be asked for the organization in charge of the platform.
	 * Based on that the usertoken is a Mandatory field for guest users or auto
	 * completed for properly registered and authenticated users."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getUserToken() {
		return userToken;
	}

	/**
	 * "Ocurrence:1 This field is auto completed with the userToken of the
	 * athenticated user, or if the user are trying to test the platform as a Guest
	 * one token should be asked for the organization in charge of the platform.
	 * Based on that the usertoken is a Mandatory field for guest users or auto
	 * completed for properly registered and authenticated users."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}



}