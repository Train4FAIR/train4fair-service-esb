package de.fraunhofer.fit.train.model_v1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "artifacts")
public class Artifacts extends TrainAbstract  implements Serializable {

	private static final long serialVersionUID = -7369246201862747847L;


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



	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
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
