package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * 3.1 titleType Occurrence: 0-1 Definition: The type of Title. Allowed values,
 * examples, other constraints: Controlled List Values:
 * 
 * AlternativeTitle Subtitle TranslatedTitle Other
 * 
 * @author jbjares
 *
 */
//@XStreamAlias("TitleType")
//@Repository
//@Document(collection = "titleType")
public enum TitleTypeDataciteEnum {

	ALTERNATIVETITLE("ALTERNATIVETITLE"), SUBTITLE("SUBTITLE"), TRANSLATEDTITLE("TRANSLATEDTITLE"), OTHER("OTHER");

	private String text;

	/**
	 * "Occurrence: 0-1 Definition: The type of Title. Allowed values, examples,
	 * other constraints: Controlled List Values: AlternativeTitle, Subtitle,
	 * TranslatedTitle, Other"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 * @param text
	 */
	TitleTypeDataciteEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static TitleTypeDataciteEnum fromString(String text) {
		for (TitleTypeDataciteEnum b : TitleTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
