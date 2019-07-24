package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 1 Definition: The type of the RelatedIdentifier Allowed values,
 * examples, other constraints: If RelatedIdentifier is used,
 * relatedIdentifierType is mandatory. Controlled List Values.."
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("RelatedIdentifierType")
//@Repository
//@Document(collection = "relatedIdentifierType")
public enum RelatedIdentifierTypeDataciteEnum {

	/**
	 * Archival Resource Key URL designed to support long-term access to information
	 * objects. In general, ARK syntax is of the form (brackets indicate [optional]
	 * elements): [http://NMA/] ark:/NAAN/Name [Qualifier]
	 * e.g:<relatedIdentifier relatedIdentifierType=\"ARK\" relationType=\"IsCitedBy\">ark:/13030/tqb3kh97gh8w </relatedIdentifier>
	 */
	ARK("ARK"),

	/**
	 * arXiv identifier arXiv.org is a repository of preprints of scientific papers
	 * in the fields of mathematics, physics, astronomy, computer science,
	 * quantitative biology, statistics, and quantitative finance.
	 * e.g:<relatedIdentifier relatedIdentifierType=”arXiv” relationType=”IsCitedBy”>arXiv:0706.0001 </relatedIdentifier>
	 */
	ARXIV("arXiv"),

	/**
	 * Astrophysics Data System bibliographic codes; a standardized 19 character
	 * identifier according to the syntax yyyyjjjjjvvvvmppppa. See description Note:
	 * bibcodes can be resolved via http://adsabs.harvard.edu/abs/bibcode
	 * 
	 * * e.g: <relatedIdentifier relatedIdentifierType=\"bibcode\" relationType=\"IsCitedBy\"> 2014Wthr...69...72C </relatedIdentifier>
	 */
	BIBCODE("bibcode"),

	/**
	 * Digital Object Identifier; a character string used to uniquely identify an
	 * object. A DOI name is divided into two parts, a prefix and a suffix,
	 * separated by a slash.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=”IsSupplementTo”> 10.1016/j.epsl.2011.11.037 </relatedIdentifier>
	 */
	DOI("DOI"),

	/**
	 * European Article Number, now renamed International Article Number, but
	 * retaining the original acronym, is a 13-digit barcoding standard which is a
	 * superset of the original 12-digit Universal Product Code (UPC) system.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"EAN13” relationType=”Cites”>9783468111242 </relatedIdentifier>
	 */
	EAN13("EAN13"),

	/**
	 * Electronic International Standard Serial Number; ISSN used to identify
	 * periodicals in electronic form (eISSN or e- ISSN).
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"eISSN” relationType=”Cites”>1562-6865 </relatedIdenfifier>
	 */
	EISSN("eISSN"),

	/**
	 * A handle is an abstract reference to a resource.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"Handle\" relationType=\"References\">10013/epic.10033 </relatedIdentifier>
	 */
	HANDLE("Handle"),

	/**
	 * IGSN International Geo Sample Number; a 9-digit alphanumeric code that
	 * uniquely identifies samples from our natural environment and related sampling
	 * features.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"IGSN\" relationType=\"References\">IECUR0097 </relatedIdentifier>
	 */
	IGSN("IGSN"),

	/**
	 * ISBN International Standard Book Number; a unique numeric book identifier.
	 * There are 2 formats: a 10-digit ISBN format and a 13-digit ISBN.
	 * 
	 * e.g: <relatedIdentifier><relatedIdentifier relatedIdentifierType=\"ISBN\" relationType=\"IsPartOf\">978-3-905673-82-1 </relatedIdentifier>
	 */

	ISBN("ISBN"),

	/**
	 * ISSN International Standard Serial Number; a unique 8-digit number used to
	 * identify a print or electronic periodical publication.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"ISSN\" relationType=\"IsPartOf\">0077-5606 </relatedIdentifier>
	 */

	ISSN("ISSN"),

	/**
	 * ISTC International Standard Text Code; a unique “number” assigned to a
	 * textual work. An ISTC consists of 16 numbers and/or letters.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"ISTC” relationType=”Cites”>0A9 2002 12B4A105 7 </relatedIdentifier>
	 */
	ISTC("ISTC"),

	/**
	 * LISSN The linking ISSN or ISSN-L enables collocation or linking among
	 * different media versions of a continuing resource.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"LISSN” relationType=”Cites”>1188-1534</relatedIdentifier>
	 */
	LISSN("LISSN"),

	/**
	 * LSID Life Science Identifiers; a unique identifier for data in the Life
	 * Science domain. Format: urn:lsid:authority:namespace:identifier:revision
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"LSID” relationType=”Cites”> urn:lsid:ubio.org:namebank:11815</relatedIdentifier>
	 */
	LSID("LSID"),

	/**
	 * PMID PubMed identifier; a unique number assigned to each PubMed record.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"PMID” relationType=”IsReferencedBy”>12082125</relatedId entifier>
	 */
	PMID("PMID"),

	/**
	 * PURL Persistent Uniform Resource Locator. A PURL has three parts: (1) a
	 * protocol, (2) a resolver address, and (3) a name.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"PURL” relationType=”Cites”> http://purl.oclc.org/foo/bar</relatedIdentifier>
	 */
	PURL("PURL"),

	/**
	 * UPC Universal Product Code is a barcode symbology used for tracking trade
	 * items in stores. Its most common form, the UPC-A, consists of 12 numerical
	 * digits.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"UPC” relationType=”Cites”> 123456789999</relatedIdentifier>
	 */
	UPC("UPC"),

	/**
	 * URL Uniform Resource Locator, also known as web address, is a specific
	 * character string that constitutes a reference to a resource. The syntax is:
	 * schema://domain:port/path?query_string#fragment_id
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URL” relationType=”IsCitedBy”>http://www.heatflow.und.edu/i ndex2.html</relatedIdentifier>
	 */
	URL("URL"),

	/**
	 * URN Uniform Resource Name; is a unique and persistent identifier of an
	 * electronic document. The syntax is: urn:<NID>:<NSS> The leading urn: sequence
	 * is case-insensitive, <NID> is the namespace identifier, <NSS> is the
	 * namespace-specific string.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URN\" relationType=”IsSupplementTo”>urn:nbn:de:101:1- 201102033592</relatedIdentifier>
	 */
	URN("URN");

	private String text;

	RelatedIdentifierTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 Definition: The type of the RelatedIdentifier Allowed values,
	 * examples, other constraints: If RelatedIdentifier is used,
	 * relatedIdentifierType is mandatory. Controlled List Values.."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static RelatedIdentifierTypeDataciteEnum fromString(String text) {
		for (RelatedIdentifierTypeDataciteEnum b : RelatedIdentifierTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}