package de.fraunhofer.fit.train.model_v2.doi.datacitie.helper;

/**
 * "Occurrence: 1 Definition: Description of the relationship of the resource
 * being registered (A) and the related resource (B). Allowed values, examples,
 * other constraints: If RelatedIdentifier is used, relationType is mandatory."
 * 
 * @author Joao Bosco Jares MSc. (Software Engineer)
 * @see www.jbjares.com
 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
 *
 *
 */
//@XStreamAlias("RelationType")
//@Repository
//@Document(collection = "relationType")
public enum RelationTypeDataciteEnum {

	/**
	 * Indicates that B includes A in a citation Recommended for discovery.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\"relationType=\"IsCited By\">10.4232/10.ASEAS-5.2-1 </relatedIdentifier>
	 */
	ISCITEDBY("IsCitedBy"),

	/**
	 * Cites Indicates that A includes B in a citation Recommended for discovery.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"ISBN” relationType=\"Cites“>0761964312 </relatedIdentifier>
	 */
	CITES("Cites"),

	/**
	 * IsSupplementTo Indicates that A is a supplement to B Recommended for
	 * discovery.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URN\" relationType=\"IsSupplementTo\">urn:nbn:de:0168-ssoar- 13172 </relatedIdentifier>
	 */
	ISSUPPLEMENTTO("IsSupplementTo"),

	/**
	 * IsSupplementedBy Indicates that B is a supplement to A Recommended for
	 * discovery.
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"PMID\" relationType=\"IsSupplementedBy\">16911322/ </relatedIdentifier>
	 */
	ISSUPPLEMENTBY("IsSupplementedBy"),

	/**
	 * IsContinuedBy Indicates A is continued by the work B
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URN\" relationType=\"IsContinuedBy\">urn:nbn:de:bsz:21-opus- 4967 </relatedIdentifier>
	 */
	ISCONTINUEDBY("IsContinuedBy"),

	/**
	 * Continues Indicates A is a continuation of the work B
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URN\" relationType=\"IsContinuedBy\">urn:nbn:de:bsz:21-opus- 4967 </relatedIdentifier> 
	 */
	CONTINUES("Continues"),

	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsDescribedBy\">10.1038/sdata.2016.123</relatedIdentifier> 
	 */
	ISDESCRIBEDBY("IsDescribedBy"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"Describes\">10.6084/m9.figshare.c.3288407</relatedIdentifier>  
	 */
	DESCRIBES("Describes"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"HasMetadata\" relatedMetadataSchema=\"DDI-L\" schemeURI=\"http://www.ddialliance.org/Specification/DDI- Lifecycle/3.1/XMLSchema/instance.xsd\">10.1234/567890</relatedIdentifier>  
	 */
	HASMETADATA("HasMetadata"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsMetadataFor “relatedMetadataSchema=\"DDI-L\" schemeURI=\"http://www.ddialliance.org/Specification/DDI- Lifecycle/3.1/XMLSchema/instance.xsd\">10.1234/567891</relatedIdentifier>  
	 */
	ISMETADATAFOR("IsMetadataFor"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"HasVersion\">10.5281/ZENODO.832053 </relatedIdentifier>  
	 */
	HASVERSION("HasVersion"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsVersionOf\">10.5281/ZENODO.832054 </relatedIdentifier>  
	 */
	ISVERSIONOF("IsVersionOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsNewVersionOf\">10.5438/0005 </relatedIdentifier>  
	 */
	ISNEWVERSIONOF("IsNewVersionOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsPreviousVersionOf\">10.5438/0007 </relatedIdentifier>  
	 */
	ISPREVIOUSVERSIONOF("IsPreviousVersionOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsPartOf\">10.5281/zenodo.754312 </relatedIdentifier>  
	 */
	ISPARTOF("IsPartOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URL\" relationType=\"HasPart\">https://zenodo.org/record/16564/files/dune-stuff-LSSC_15.zip</relatedIdentifier>  
	 */
	HASPART("HasPart"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsVersionOf\">10.5281/ZENODO.832054 </relatedIdentifier>  
	 */
	ISREFERENCEDBY("IsVersionOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URN\" relationType=\"References\">urn:nbn:de:bsz:21-opus- 963</relatedIdentifier>  
	 */
	REFERENCES("References"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URL\" relationType=\"IsDocumentedBy\">http://tobias-lib.uni-tuebingen.de/volltexte/2000/96/ </relatedIdentifier>  
	 */
	ISDOCUMENTEDBY("IsDocumentedBy"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"Documents\">10.1234/7836 </relatedIdentifier>  
	 */
	DOCUMENTS("Documents"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URL\" relationType=\"isCompiledBy\">http://d- nb.info/gnd/4513749-3 </relatedIdentifier>  
	 */
	ISCOMPILEDBY("isCompiledBy"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URN\" relationType=\"Compiles\">urn:nbn:de:bsz:21-opus-963 </relatedIdentifier>  
	 */
	COMPILES("Compiles"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsVariantFormOf\">10.1234/8675 </relatedIdentifier>  
	 */
	ISVARIANTFORMOF("IsVariantFormOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsOriginalFormOf\">10.1234/9035 </relatedIdentifier>  
	 */
	ISORIGINALFORMOF("IsOriginalFormOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URL\" relationType=\"IsIdenticalTo\">http://oac.cdlib.org/findaid/ar k:/13030/c8r78fzq </relatedIdentifier>  
	 */
	ISIDENTICALTO("IsIdenticalTo"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsReviewedBy\">10.5256/F1000RESEARCH.4288.R4745 </relatedIdentifier>  
	 */
	ISREVIEWEDBY("IsReviewedBy"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"Reviews\">10.12688/f1000research.4001.1</relatedIdentifier>  
	 */
	REVIEWS("Reviews"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsDerivedFrom\">10.6078/M7DZ067C </relatedIdentifier>  
	 */
	ISDERIVEDFROM("IsDerivedFrom"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"URL\" relationType=\"IsSourceOf\"> http://opencontext.org/projects/81204AF8-127C-4686-E9B0- 1202C3A47959 </relatedIdentifier>  
	 */
	ISSOURCEOF("IsSourceOf"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"IsRequiredBy\">10.1234/8675 </relatedIdentifier>  
	 */
	ISREQUIREDBY("IsRequiredBy"),
	
	/**
	 * 
	 * e.g: <relatedIdentifier relatedIdentifierType=\"DOI\" relationType=\"Requires\">10.1234/8675 </relatedIdentifier>  
	 */
	REQUIRES("Requires");

	private String text;

	RelationTypeDataciteEnum(String text) {
		this.text = text;
	}

	/**
	 * "Occurrence: 1 Definition: Description of the relationship of the resource
	 * being registered (A) and the related resource (B). Allowed values, examples,
	 * other constraints: If RelatedIdentifier is used, relationType is mandatory."
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 */
	public String getText() {
		return this.text;
	}

	public static RelationTypeDataciteEnum fromString(String text) {
		for (RelationTypeDataciteEnum b : RelationTypeDataciteEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}