package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * 1.1) identifierType Controled List M DataCite/Identifier
 * http://bit.ly/2ZoRw8P "Occurrence: 1 Definition: The type of Identifier.
 * Allowed values, examples, other constraints: Controlled List Value: DOI"
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */

//@XStreamAlias("IdentifierType")
//@Repository
//@Document(collection = "identifierType")
public enum IdentifierTypeDataciteEnum {

	DOI("DOI"),ORCID("ORCID");

	private String text;

	IdentifierTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * 1.1) identifierType Controled List M DataCite/Identifier
	 * http://bit.ly/2ZoRw8P "Occurrence: 1 Definition: The type of Identifier.
	 * Allowed values, examples, other constraints: Controlled List Value: DOI"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static IdentifierTypeDataciteEnum fromString(String text) {
		for (IdentifierTypeDataciteEnum b : IdentifierTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
