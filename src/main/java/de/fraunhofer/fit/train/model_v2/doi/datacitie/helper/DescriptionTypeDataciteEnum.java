package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 1 Definition: The type of the Description. Allowed values,
 * examples, other constraints: If Description is used, descriptionType is
 * mandatory."
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("DescriptionType")
//@Repository
//@Document(collection = "dateType")
public enum DescriptionTypeDataciteEnum {

	METHODS("methods"), SERIESINFORMATION("seriesInformation"), TABLEOFCONTENTS("tableOfContents"),
	TECHNICALINFO("technicalInfo"), OTHER("other");

	private String text;

	DescriptionTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 Definition: The type of the Description. Allowed values,
	 * examples, other constraints: If Description is used, descriptionType is
	 * mandatory."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static DescriptionTypeDataciteEnum fromString(String text) {
		for (DescriptionTypeDataciteEnum b : DescriptionTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}