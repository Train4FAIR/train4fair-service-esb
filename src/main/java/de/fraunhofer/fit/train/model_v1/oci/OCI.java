package de.fraunhofer.fit.train.model_v1.oci;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement
@Repository
@Document(collection = "oci")
public class OCI {

	@SerializedName("created")
	@Expose
	private String created;

	@SerializedName("author")
	@Expose
	private String author;

	@SerializedName("architecture")
	@Expose
	private String architecture;

	@SerializedName("os")
	@Expose
	private String os;

	@SerializedName("config")
	@Expose
	private Config config;

	/**
	 * An combined date and time at which the image was created, formatted as
	 * defined by RFC 3339, section 5.6.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * An combined date and time at which the image was created, formatted as
	 * defined by RFC 3339, section 5.6.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Gives the name and/or email address of the person or entity which created and
	 * is responsible for maintaining the image.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gives the name and/or email address of the person or entity which created and
	 * is responsible for maintaining the image.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * The CPU architecture which the binaries in this image are built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOARCH.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * The CPU architecture which the binaries in this image are built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOARCH.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	/**
	 * The name of the operating system which the image is built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOOS.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getOs() {
		return os;
	}

	/**
	 * The name of the operating system which the image is built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOOS.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * The execution parameters which SHOULD be used as a base when running a
	 * container using the image. This field can be null, in which case any
	 * execution parameters should be specified at creation of the container.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public Config getConfig() {
		return config;
	}

	/**
	 * The execution parameters which SHOULD be used as a base when running a
	 * container using the image. This field can be null, in which case any
	 * execution parameters should be specified at creation of the container.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setConfig(Config config) {
		this.config = config;
	}

}
