


package de.fraunhofer.fit.train.model_v2.doi.datacite;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



@XmlRootElement(name = "resource")
@Repository
@Document(collection = "datacite")
@XmlType(propOrder = {"identifier", "creators","titles","publisher","publicationYear","subjects","contributors","dates","language",
		"resourceType","alternateIdentifiers","relatedIdentifiers","sizes","formats","version","rightsList","descriptions",
		"fundingReferences"})
public class Datacite {

	
	@Id
	@SerializedName("_id")
	@Expose
	private ObjectId _id;
	
	@SerializedName("identifier")
	@Expose
	private Identifier identifier;//*

	@SerializedName("formats")
	@Expose
	private Formats formats;

	@SerializedName("rightsList")
	@Expose
	private RightsList rightsList;

	@SerializedName("creators")
	@Expose
	private Creators creators;//*

	@SerializedName("subjects")
	@Expose
	private Subjects subjects;

	@SerializedName("dates")
	@Expose
	private Dates dates;

	@SerializedName("language")
	@Expose
	private String language;//*

	@SerializedName("titles")
	@Expose
	private Titles titles;//*

	@SerializedName("relatedIdentifiers")
	@Expose
	private RelatedIdentifiers relatedIdentifiers;

	@SerializedName("version")
	@Expose
	private String version;

	@SerializedName("descriptions")
	@Expose
	private Descriptions descriptions;

	//private GeoLocations geoLocations;

	@SerializedName("alternateIdentifiers")
	@Expose
	private AlternateIdentifiers alternateIdentifiers;

	@SerializedName("sizes")
	@Expose
	private Sizes sizes;

	@SerializedName("publisher")
	@Expose
	private String publisher;

	@SerializedName("publicationYear")
	@Expose
	private String publicationYear;

	@SerializedName("contributors")
	@Expose
	private Contributors contributors;//

	
	@SerializedName("fundingReferences")
	@Expose
	private FundingReferences fundingReferences;

	
	@SerializedName("resourceType")
	@Expose
	private ResourceType resourceType;
	
	


	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public Identifier getIdentifier() {
		return identifier;
	}


	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}


	public Formats getFormats() {
		return formats;
	}


	public void setFormats(Formats formats) {
		this.formats = formats;
	}


	public RightsList getRightsList() {
		return rightsList;
	}


	public void setRightsList(RightsList rightsList) {
		this.rightsList = rightsList;
	}


	public Creators getCreators() {
		return creators;
	}


	public void setCreators(Creators creators) {
		this.creators = creators;
	}


	public Subjects getSubjects() {
		return subjects;
	}


	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}


	public Dates getDates() {
		return dates;
	}


	public void setDates(Dates dates) {
		this.dates = dates;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Titles getTitles() {
		return titles;
	}


	public void setTitles(Titles titles) {
		this.titles = titles;
	}


	public RelatedIdentifiers getRelatedIdentifiers() {
		return relatedIdentifiers;
	}


	public void setRelatedIdentifiers(RelatedIdentifiers relatedIdentifiers) {
		this.relatedIdentifiers = relatedIdentifiers;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public Descriptions getDescriptions() {
		return descriptions;
	}


	public void setDescriptions(Descriptions descriptions) {
		this.descriptions = descriptions;
	}


	public AlternateIdentifiers getAlternateIdentifiers() {
		return alternateIdentifiers;
	}


	public void setAlternateIdentifiers(AlternateIdentifiers alternateIdentifiers) {
		this.alternateIdentifiers = alternateIdentifiers;
	}


	public Sizes getSizes() {
		return sizes;
	}


	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPublicationYear() {
		return publicationYear;
	}


	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}


	public Contributors getContributors() {
		return contributors;
	}


	public void setContributors(Contributors contributors) {
		this.contributors = contributors;
	}


	public FundingReferences getFundingReferences() {
		return fundingReferences;
	}


	public void setFundingReferences(FundingReferences fundingReferences) {
		this.fundingReferences = fundingReferences;
	}


	public ResourceType getResourceType() {
		return resourceType;
	}


	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}


	

}
