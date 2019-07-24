package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 1 Definition: The type of contributor of the resource. Allowed
 * values, examples, other constraints: If Contributor is used, then
 * contributorType is mandatory. Controlled List Values…"
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("ContributorType")
//@Repository
//@Document(collection = "contributorType")
public enum ContributorTypeDataciteEnum {

	CONTACTPERSON("CONTACTPERSON"), DATACOLLECTOR("DATACOLLECTOR"), DATACURATOR("DATACURATOR"),
	DATAMANAGER("DATAMANAGER"), DISTRIBUTOR("DISTRIBUTOR"), EDITOR("EDITOR"), HOSTINGINSTITUTION("HOSTINGINSTITUTION"),
	PRODUCER("PRODUCER"), PROJECTLEADER("PROJECTLEADER"), PROJECTMANAGER("PROJECTMANAGER"),
	PROJECTMEMBER("PROJECTMEMBER"), REGISTRATIONAGENCY("REGISTRATIONAGENCY"),
	REGISTRATIONAUTHORITY("REGISTRATIONAUTHORITY"), RELATEDPERSON("RELATEDPERSON"), RESEARCHER("RESEARCHER"),
	RESEARCHGROUP("RESEARCHGROUP"), RIGHTSHOLDER("RIGHTSHOLDER"), SPONSOR("SPONSOR"), SUPERVISOR("SUPERVISOR"),
	WORKPACKAGELEADER("WORKPACKAGELEADER"), OTHER("OTHER");

	private String text;

	ContributorTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 Definition: The type of contributor of the resource. Allowed
	 * values, examples, other constraints: If Contributor is used, then
	 * contributorType is mandatory. Controlled List Values…"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static ContributorTypeDataciteEnum fromString(String text) {
		for (ContributorTypeDataciteEnum b : ContributorTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}