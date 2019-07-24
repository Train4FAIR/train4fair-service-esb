package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 0-1 Definition: The type of name Allowed values, examples, other
 * constraints: Controlled List Values: Organizational, Personal (default)"
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("NameType")
//@Repository
//@Document(collection = "nameType")
public enum NameTypeDataciteEnum {

	ORGANIZATIONAL("ORGANIZATIONAL"), PERSONAL("PERSONAL");

	private String text;

	NameTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 0-1 Definition: The type of name Allowed values, examples, other
	 * constraints: Controlled List Values: Organizational, Personal (default)"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static NameTypeDataciteEnum fromString(String text) {
		for (NameTypeDataciteEnum b : NameTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
