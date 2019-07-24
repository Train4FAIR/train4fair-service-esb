package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum OsOciEnum {

	ANDROID("android"), DARWIN("darwin"), DRAGONFLY("dragonfly"), FREEBSD("freebsd"), LINUX("linux"), NETBSD("netbsd"),
	OPENBSD("openbsd"), PLAN9("plan9"), SOLARIS("solaris"), WINDOWS("windows");

	private String text;

	OsOciEnum(String text) {
		this.text = text;
	}

	/**
	 * The name of the operating system which the image is built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOOS.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * The name of the operating system which the image is built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOOS.
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	@XmlElement
	public String setText(String text) {
		return this.text = text;
	}

	public static OsOciEnum fromString(String text) {
		for (OsOciEnum b : OsOciEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
