package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum ArchitectureOCIEnum {
	ARM("arm"), ARM64("arm64"), PPC64("ppc64"), PPC64LE("ppc64le"), MIPS("mips"), MIPSLE("mipsle"), MIPS64("mips64"),
	MIPS64LE("mips64le"), S390X("s390x"), AMD64("amd64"), _386("386");

	private String text;

	ArchitectureOCIEnum(String text) {
		this.text = text;
	}

	/**
	 * The CPU architecture which the binaries in this image are built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOARCH.
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
	 * The CPU architecture which the binaries in this image are built to run on.
	 * Configurations SHOULD use, and implementations SHOULD understand, values
	 * listed in the Go Language document for GOARCH.
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

	public static ArchitectureOCIEnum fromString(String text) {
		for (ArchitectureOCIEnum b : ArchitectureOCIEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
