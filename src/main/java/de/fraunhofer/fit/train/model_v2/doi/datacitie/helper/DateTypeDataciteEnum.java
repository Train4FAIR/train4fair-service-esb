package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 1 Definition: The type of date. Allowed values, examples, other
 * constraints: If Date is used, dateType is mandatory. Controlled List Values…"
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("DateType")
//@Repository
//@Document(collection = "dateType")
public enum DateTypeDataciteEnum {
	ACCEPTED("ACCEPTED"), AVAILABLE("AVAILABLE"), COPYRIGHTED("COPYRIGHTED"), COLLECTED("COLLECTED"),
	CREATED("CREATED"), ISSUED("ISSUED"), SUBMITTED("SUBMITTED"), UPDATED("UPDATED"), VALID("VALID"), OTHER("OTHER");

	private String text;

	DateTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 Definition: The type of date. Allowed values, examples, other
	 * constraints: If Date is used, dateType is mandatory. Controlled List Values…"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static DateTypeDataciteEnum fromString(String text) {
		for (DateTypeDataciteEnum b : DateTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}