package de.fraunhofer.fit.train.model_v1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "artifacts")
public class Artifacts implements Serializable {

	private static final long serialVersionUID = -7369246201862747847L;

	@SerializedName("name")
	@Expose
	private String name;//

	@SerializedName("filename") //
	@Expose
	private String filename;

	@SerializedName("filedata") //
	@Expose
	private String filedata;

	@SerializedName("format") //
	@Expose
	private String format;//

	@SerializedName("checksum")
	@Expose
	private String checksum;

	@SerializedName("fileUrl")
	@Expose
	private String fileUrl;

	@SerializedName("extension")
	@Expose
	private String extension;

	@SerializedName("description")
	@Expose
	private String description;

	@Id
	private ObjectId _id;

	
	
	
	
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

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

	@SerializedName("resourceId")
	@Expose
	private String resourceId;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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

}
