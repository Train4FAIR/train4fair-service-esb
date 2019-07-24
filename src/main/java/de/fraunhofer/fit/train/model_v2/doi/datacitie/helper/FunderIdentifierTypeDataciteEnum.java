package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 0-1 Definition: The type of the funderIdentifier. Allowed
 * values, examples, other constraints: Controlled List Values: ISNI, GRID,
 * Other"
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("FunderIdentifierType")
//@Repository
//@Document(collection = "funderIdentifierType")
public enum FunderIdentifierTypeDataciteEnum {

	ISNI("ISNI"), GRID("GRID"), CROSSREF_FUNDER("CROSSREF_FUNDER"), OTHER("OTHER");

	private String text;

	FunderIdentifierTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 0-1 Definition: The type of the funderIdentifier. Allowed
	 * values, examples, other constraints: Controlled List Values: ISNI, GRID,
	 * Other"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static FunderIdentifierTypeDataciteEnum fromString(String text) {
		for (FunderIdentifierTypeDataciteEnum b : FunderIdentifierTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
