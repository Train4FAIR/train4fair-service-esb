package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * 10.1 resourceTypeGeneral Occurrence: 1 Definition: The general type of a
 * resource. Allowed values, examples, other constraints: Controlled List
 * Values: Audiovisual A series of visual representations imparting an
 * impression of motion when shown in succession. May or may not include sound.
 * May be used for films, video, etc.
 * 
 * Example:
 * https://data.datacite.org/application/vnd.datacite.datacite+xml/10.17608/K6.AUCKLAND.4620790.V1
 * 
 * Suggested Dublin Core mapping: MovingImage
 * 
 * Collection An aggregation of resources, which may encompass collections of
 * one resourceType as well as those of mixed types. A collection is described
 * as a group; its parts may also be separately described.
 * 
 * Example: A collection of samples, or various files making up a report.
 * https://data.datacite.org/application/vnd.datacite.datacite+xml/10.52
 * 84/1001038
 * 
 * Suggested Dublin Core mapping: Collection
 * 
 * DataPaper..
 * 
 * @author jbjares
 *
 */

//@XStreamAlias("ResourceTypeGeneral")
//@Repository
//@Document(collection = "resourceTypeGeneral")
public enum ResourceTypeGeneralDataciteEnum {

	AUDIOVISUAL("AUDIOVISUAL"), COLLECTION("COLLECTION"), DATAPAPER("DATAPAPER"), DATASET("DATASET"), EVENT("EVENT"),
	IMAGE("IMAGE"), INTERACTIVERESOURCE("INTERACTIVERESOURCE"), MODEL("MODEL"), PHYSICALOBJECT("PHYSICALOBJECT"),
	SERVICE("SERVICE"), SOFTWARE("SOFTWARE"), SOUND("SOUND"), TEXT("TEXT"), WORKFLOW("WORKFLOW"), TRAIN("TRAIN"),
	OTHER("OTHER");

	private String text;

	ResourceTypeGeneralDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 Definition: The general type of a resource. Allowed values,
	 * examples, other constraints: Controlled List Values: Audiovisual A series of
	 * visual representations imparting an impression of motion when shown in
	 * succession. May or may not include sound. May be used for films, video, etc."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static ResourceTypeGeneralDataciteEnum fromString(String text) {
		for (ResourceTypeGeneralDataciteEnum b : ResourceTypeGeneralDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
