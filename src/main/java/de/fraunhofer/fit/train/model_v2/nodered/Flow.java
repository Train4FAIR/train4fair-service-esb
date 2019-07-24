package de.fraunhofer.fit.train.model_v2.nodered;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
 *
 */
@XmlRootElement
@Repository
@Document(collection = "flow")
public class Flow {

	@SerializedName("flowID")
	@Expose
	private String flowID;
	
	
	@SerializedName("flowTabName")
	@Expose
	private String flowTabName;


	@SerializedName("launchTrainPlatformURL")
	@Expose
	private String launchTrainPlatformURL;


	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("filename")
	@Expose
	private String filename;

	@SerializedName("filedata")
	@Expose
	private String filedata;

	@SerializedName("format")
	@Expose
	private String format;

	@SerializedName("checksum")
	@Expose
	private String checksum;

	@SerializedName("fileUrl")
	@Expose
	private String fileUrl;

	
	@SerializedName("description")
	@Expose
	private String description;

	
	
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
	 * fileURL aims to be the holder for the endpoint to retrieve the concrete file,
	 * such as a FTP, Webdav, or any other File repository.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * fileURL aims to be the holder for the endpoint to retrieve the concrete file,
	 * such as a FTP, Webdav, or any other File repository.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


	/**
	 * "The checksum is an auto-genereted field which aims to be the holder of the
	 * MD5 hash, used to validate the integrity of the all files under the link
	 * between one Resource as his group of artifacts. As these files are stored
	 * under the same folder (which the name is the internalPointer of the outer
	 * Object, The Train). In this way, all the files is compressed and the checksum
	 * ir generated over the compressed file."
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
	 * "The checksum is an auto-genereted field which aims to be the holder of the
	 * MD5 hash, used to validate the integrity of the all files under the link
	 * between one Resource as his group of artifacts. As these files are stored
	 * under the same folder (which the name is the internalPointer of the outer
	 * Object, The Train). In this way, all the files is compressed and the checksum
	 * ir generated over the compressed file."
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
	 * "Occurrence: 1 This field aims to hold an optional name for the artifact
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
	 * "Occurrence: 1 This field aims to hold an optional name for the artifact
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
	 * "This field aims to hold the concrete name of the file which is in charger.
	 * cuch as: Artifact name, or file name. eg.: script.py, dependecies.txt"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * "This field aims to hold the concrete name of the file which is in charger.
	 * cuch as: Artifact name, or file name. eg.: script.py, dependecies.txt"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * The content of the Artifact/File, in String format.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getFiledata() {
		return filedata;
	}

	/**
	 * The content of the Artifact/File, in String format.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}

	/**
	 * The format or the file encoding, such as UTF-8, ISO 8859, Hexadecimal
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * The format or the file encoding, such as UTF-8, ISO 8859, Hexadecimal
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFormat(String format) {
		this.format = format;
	}


	/**
	 * "Occurrence: 1 The flowID attribute holds the id of the flow, which is used
	 * to manipulate the node-red API properly."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getFlowID() {
		return flowID;
	}

	/**
	 * "Occurrence: 1 The flowID attribute holds the id of the flow, which is used
	 * to manipulate the node-red API properly."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}

	/**
	 * "Occurrence: 1 The launchTrainPlatform, represented by an URL, aims to
	 * redirect an user from enother platform, or even inside the Train Platform.
	 * What happens is: If the user is outside the Train Platform then the user is
	 * redirected to the Train Platform Login Page, If it's an already registered
	 * user the application opens and plots in to the screen the whole workflow
	 * already defined by that Train. However, if the user is not a member, could
	 * access the registration area. After the registration process should be the
	 * same. Of course, all the such as Read, Write, etc.. Depends of how the owner
	 * of the Train have defined before. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getLaunchTrainPlatformURL() {
		return launchTrainPlatformURL;
	}

	/**
	 * "Occurrence: 1 The launchTrainPlatform, represented by an URL, aims to
	 * redirect an user from enother platform, or even inside the Train Platform.
	 * What happens is: If the user is outside the Train Platform then the user is
	 * redirected to the Train Platform Login Page, If it's an already registered
	 * user the application opens and plots in to the screen the whole workflow
	 * already defined by that Train. However, if the user is not a member, could
	 * access the registration area. After the registration process should be the
	 * same. Of course, all the such as Read, Write, etc.. Depends of how the owner
	 * of the Train have defined before. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setLaunchTrainPlatformURL(String launchTrainPlatformURL) {
		this.launchTrainPlatformURL = launchTrainPlatformURL;
	}

	public String getFlowTabName() {
		return flowTabName;
	}

	
	/**
	 * "Occurrence: 1 This field aims to identification of the tab which the flow is 
	 * developed inside the Train Modelling Tool Platform.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setFlowTabName(String flowTabName) {
		this.flowTabName = flowTabName;
	}
	
	

}
