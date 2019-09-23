package de.fraunhofer.fit.train.model_v2.nodered;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

	@SerializedName("flowURL")
	@Expose
	private String flowURL;

	@SerializedName("description")
	@Expose
	private String description;
	
	@SerializedName("documentationEntrypoint")
	@Expose
	private String documentationEntrypoint;
	
	

	/**
	 * "Occurrence: 1 The flowURL, represented by an URL, aims to redirect an user
	 * to the oficial landpage of the project, which should contains access points
	 * as url links to access the Train metadata, the Train Modelling Tool endpoint
	 * for the related project, as well as, the Rest API, Javadoc, and much more. This
	 * entrypoint url should be configured as the landepage of the project inside other
	 * partners platforms, such as Datacite, Fordata etc..
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getDocumentationEntrypoint() {
		return documentationEntrypoint;
	}

	/**
	 * "Occurrence: 1 The flowURL, represented by an URL, aims to redirect an user
	 * to the oficial landpage of the project, which should contains access points
	 * as url links to access the Train metadata, the Train Modelling Tool endpoint
	 * for the related project, as well as, the Rest API, Javadoc, and much more. This
	 * entrypoint url should be configured as the landepage of the project inside other
	 * partners platforms, such as Datacite, Fordata etc..
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public void setDocumentationEntrypoint(String documentationEntrypoint) {
		this.documentationEntrypoint = documentationEntrypoint;
	}

	/**
	 * "Occurrence: 1 The flowURL, represented by an URL, aims to redirect an user
	 * from enother platform, or even inside the Train Platform. What happens is: If
	 * the user is outside the Train Platform then the user is redirected to the
	 * Train Platform Login Page, If it's an already registered user the application
	 * opens and plots in to the screen the whole workflow already defined by that
	 * Train. However, if the user is not a member, could access the registration
	 * area. After the registration process should be the same. Of course, all the
	 * such as Read, Write, etc.. Depends of how the owner of the Train have defined
	 * before. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getFlowURL() {
		return flowURL;
	}

	/**
	 * "Occurrence: 1 The flowURL, represented by an URL, aims to redirect an user
	 * from enother platform, or even inside the Train Platform. What happens is: If
	 * the user is outside the Train Platform then the user is redirected to the
	 * Train Platform Login Page, If it's an already registered user the application
	 * opens and plots in to the screen the whole workflow already defined by that
	 * Train. However, if the user is not a member, could access the registration
	 * area. After the registration process should be the same. Of course, all the
	 * such as Read, Write, etc.. Depends of how the owner of the Train have defined
	 * before. "
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public void setFlowURL(String flowURL) {
		this.flowURL = flowURL;
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

}
