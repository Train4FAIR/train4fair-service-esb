package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * "Occurrence: 1 - n The stationProfiles aims to hold the logic domain name
 * regarding each station, such as Hepatitis, Cancer, Obesity, Diabetes etc…"
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
@XStreamAlias("StationProfileEnum")
//@Repository
//@Document(collection = "resourceTypeGeneral")
public enum StationProfileEnum {

	CANCER("Cancer"), HEPATITIS("Hepatitis"), OBESITY("Obesity"), DIABETES("Diabetes");

	private String text;

	StationProfileEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 - n The stationProfiles aims to hold the logic domain name
	 * regarding each station, such as Hepatitis, Cancer, Obesity, Diabetes etc…"
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static StationProfileEnum fromString(String text) {
		for (StationProfileEnum b : StationProfileEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
