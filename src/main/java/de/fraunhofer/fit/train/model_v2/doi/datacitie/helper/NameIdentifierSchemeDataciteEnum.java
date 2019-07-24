package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * 
 * 2.4.1 nameIdentifierScheme Occurrence: 1 Definition: The name of the name
 * identifier schema. Allowed values, examples, other constraints: If
 * nameIdentifier is used, nameIdentifierScheme is mandatory. Examples:
 * 
 * ORCID. When entering an ORCID, follow these style guidelines ISNI
 *
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("NameIdentifierScheme")
//@Repository
//@Document(collection = "nameIdentifierScheme")
public enum NameIdentifierSchemeDataciteEnum {

	ORCID("ORCID"), ISNI("ISNI");

	private String text;

	NameIdentifierSchemeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * 
	 * 2.4.1 nameIdentifierScheme Occurrence: 1 Definition: The name of the name
	 * identifier schema. Allowed values, examples, other constraints: If
	 * nameIdentifier is used, nameIdentifierScheme is mandatory. Examples:
	 * 
	 * ORCID. When entering an ORCID, follow these style guidelines ISNI
	 */
	public String getText() {
		return this.text;
	}

	public static NameIdentifierSchemeDataciteEnum fromString(String text) {
		for (NameIdentifierSchemeDataciteEnum b : NameIdentifierSchemeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}