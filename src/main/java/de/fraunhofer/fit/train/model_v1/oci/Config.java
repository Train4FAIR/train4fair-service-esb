package de.fraunhofer.fit.train.model_v1.oci;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The execution parameters which SHOULD be used as a base when running a
 * container using the image. This field can be null, in which case any
 * execution parameters should be specified at creation of the container.
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
@XmlRootElement
@Repository
@Document(collection = "config")
public class Config {

	@SerializedName("user")
	@Expose
	private String user;

	// TODO review the object format es described in the documentation.
	@SerializedName("exposedPorts")
	@Expose
	private ExposedPorts[] exposedPort;

	// TODO review the object format es described in the documentation.
	@SerializedName("env")
	@Expose
	private String[] env;

	@SerializedName("entrypoint")
	@Expose
	private String[] entrypoint;

	@SerializedName("cmd")
	@Expose
	private String[] cmd;

	// TODO review the object format es described in the documentation.
	@SerializedName("volumes")
	@Expose
	private String[] volumes;


	@SerializedName("workingDir")
	@Expose
	private String workingDir;

	// TODO review the object format es described in the documentation.
	@SerializedName("labels")
	@Expose
	private String[] labels;

	// TODO review the object format es described in the documentation.
	@SerializedName("stopSignal")
	@Expose
	private String stopSignal;

	// TODO review the object format es described in the documentation.
	@SerializedName("rootfs")
	@Expose
	private String rootfs;

	@SerializedName("type")
	@Expose
	private String type;

	@SerializedName("diff_ids")
	@Expose
	private String[] diff_ids;

	// TODO implement it if necessary.
	// private History history;

	/**
	 * "Sets the current working directory of the entrypoint process in the
	 * container. This value acts as a default and may be replaced by a working
	 * directory specified when creating a container. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getWorkingDir() {
		return workingDir;
	}

	/**
	 * "Sets the current working directory of the entrypoint process in the
	 * container. This value acts as a default and may be replaced by a working
	 * directory specified when creating a container. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	/**
	 * The field contains arbitrary metadata for the container. This property MUST
	 * use the annotation rules.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String[] getLabels() {
		return labels;
	}

	/**
	 * The field contains arbitrary metadata for the container. This property MUST
	 * use the annotation rules.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	/**
	 * The field contains the system call signal that will be sent to the container
	 * to exit. The signal can be a signal name in the format SIGNAME, for instance
	 * SIGKILL or SIGRTMIN+3.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getStopSignal() {
		return stopSignal;
	}

	/**
	 * The field contains the system call signal that will be sent to the container
	 * to exit. The signal can be a signal name in the format SIGNAME, for instance
	 * SIGKILL or SIGRTMIN+3.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setStopSignal(String stopSignal) {
		this.stopSignal = stopSignal;
	}

	/**
	 * The rootfs key references the layer content addresses used by the image. This
	 * makes the image config hash depend on the filesystem hash.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getRootfs() {
		return rootfs;
	}

	/**
	 * The rootfs key references the layer content addresses used by the image. This
	 * makes the image config hash depend on the filesystem hash.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setRootfs(String rootfs) {
		this.rootfs = rootfs;
	}

	/**
	 * MUST be set to layers. Implementations MUST generate an error if they
	 * encounter a unknown value while verifying or unpacking an image.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getType() {
		return type;
	}

	/**
	 * MUST be set to layers. Implementations MUST generate an error if they
	 * encounter a unknown value while verifying or unpacking an image.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * An array of layer content hashes (DiffIDs), in order from first to last.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String[] getDiff_ids() {
		return diff_ids;
	}

	/**
	 * An array of layer content hashes (DiffIDs), in order from first to last.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setDiff_ids(String[] diff_ids) {
		this.diff_ids = diff_ids;
	}

	/**
	 * The username or UID which is a platform-specific structure that allows
	 * specific control over which user the process run as. This acts as a default
	 * value to use when the value is not specified when creating a container. For
	 * Linux based systems, all of the following are valid: user, uid, user:group,
	 * uid:gid, uid:group, user:gid. If group/gid is not specified, the default
	 * group and supplementary groups of the given user/uid in /etc/passwd from the
	 * container are applied.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getUser() {
		return user;
	}

	/**
	 * The username or UID which is a platform-specific structure that allows
	 * specific control over which user the process run as. This acts as a default
	 * value to use when the value is not specified when creating a container. For
	 * Linux based systems, all of the following are valid: user, uid, user:group,
	 * uid:gid, uid:group, user:gid. If group/gid is not specified, the default
	 * group and supplementary groups of the given user/uid in /etc/passwd from the
	 * container are applied.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Entries are in the format of VARNAME=VARVALUE. These values act as defaults
	 * and are merged with any specified when creating a container.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String[] getEnv() {
		return env;
	}

	/**
	 * Entries are in the format of VARNAME=VARVALUE. These values act as defaults
	 * and are merged with any specified when creating a container.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setEnv(String[] env) {
		this.env = env;
	}

	/**
	 * A set of ports to expose from a container running this image. Its keys can be
	 * in the format of: port/tcp, port/udp, port with the default protocol being
	 * tcp if not specified. These values act as defaults and are merged with any
	 * specified when creating a container. NOTE: This JSON structure value is
	 * unusual because it is a direct JSON serialization of the Go type
	 * map[string]struct{} and is represented in JSON as an object mapping its keys
	 * to an empty object.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public ExposedPorts[] getExposedPort() {
		return exposedPort;
	}

	/**
	 * A set of ports to expose from a container running this image. Its keys can be
	 * in the format of: port/tcp, port/udp, port with the default protocol being
	 * tcp if not specified. These values act as defaults and are merged with any
	 * specified when creating a container. NOTE: This JSON structure value is
	 * unusual because it is a direct JSON serialization of the Go type
	 * map[string]struct{} and is represented in JSON as an object mapping its keys
	 * to an empty object.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setExposedPort(ExposedPorts[] exposedPort) {
		this.exposedPort = exposedPort;
	}

	/**
	 * A list of arguments to use as the command to execute when the container
	 * starts. These values act as defaults and may be replaced by an entrypoint
	 * specified when creating a container.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String[] getEntrypoint() {
		return entrypoint;
	}

	/**
	 * A list of arguments to use as the command to execute when the container
	 * starts. These values act as defaults and may be replaced by an entrypoint
	 * specified when creating a container.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setEntrypoint(String[] entrypoint) {
		this.entrypoint = entrypoint;
	}

	/**
	 * Default arguments to the entrypoint of the container. These values act as
	 * defaults and may be replaced by any specified when creating a container. If
	 * an Entrypoint value is not specified, then the first entry of the Cmd array
	 * SHOULD be interpreted as the executable to run.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	
	public String[] getCmd() {
		return cmd;
	}

	/**
	 * Default arguments to the entrypoint of the container. These values act as
	 * defaults and may be replaced by any specified when creating a container. If
	 * an Entrypoint value is not specified, then the first entry of the Cmd array
	 * SHOULD be interpreted as the executable to run.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setCmd(String[] cmd) {
		this.cmd = cmd;
	}

	/**
	 * "A set of directories describing where the process is likely write data
	 * specific to a container instance. NOTE: This JSON structure value is unusual
	 * because it is a direct JSON serialization of the Go type map[string]struct{}
	 * and is represented in JSON as an object mapping its keys to an empty object.
	 * "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String[] getVolumes() {
		return volumes;
	}

	/**
	 * "A set of directories describing where the process is likely write data
	 * specific to a container instance. NOTE: This JSON structure value is unusual
	 * because it is a direct JSON serialization of the Go type map[string]struct{}
	 * and is represented in JSON as an object mapping its keys to an empty object.
	 * "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public void setVolumes(String[] volumes) {
		this.volumes = volumes;
	}

}
