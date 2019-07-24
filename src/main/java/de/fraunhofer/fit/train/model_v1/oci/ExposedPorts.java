package de.fraunhofer.fit.train.model_v1.oci;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

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
 *
 */
@XmlRootElement
@Repository
@Document(collection = "exposedports")
public class ExposedPorts {


	@SerializedName("port")
	@Expose
	private String port;


	@SerializedName("protocol")
	@Expose
	private String protocol;

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
	public String getPort() {
		return port;
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
	public void setPort(String port) {
		this.port = port;
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
	public String getProtocol() {
		return protocol;
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
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

}
