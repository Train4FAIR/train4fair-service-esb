package de.fraunhofer.fit.train.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v2.doi.datacite.AlternateIdentifiers;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Contributors;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Creators;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Dates;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Descriptions;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Formats;
import de.fraunhofer.fit.train.model_v2.doi.datacite.FundingReferences;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Identifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RelatedIdentifiers;
import de.fraunhofer.fit.train.model_v2.doi.datacite.ResourceType;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RightsList;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Sizes;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Subjects;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Titles;


@XmlRootElement(name = "resource", namespace = "http://datacite.org/schema/kernel-4")
@Repository
@Document(collection = "doitrain")
@XmlType(propOrder = {"identifier", "creators","titles","publisher","publicationYear","subjects","contributors","dates","language",
		"resourceType","alternateIdentifiers","relatedIdentifiers","sizes","formats","version","rightsList","descriptions",
		"fundingReferences","train","_id"})
public class TrainWrapper {
	
	@Id
	@SerializedName("_id")
	@Expose
	private ObjectId _id;
	
	
	@SerializedName("train")
	@Expose
	private Train train;
	

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
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


	public Identifier getIdentifier() {
		return identifier;
	}

	@XmlElement
	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}


	public Formats getFormats() {
		return formats;
	}


	@XmlElement
	public void setFormats(Formats formats) {
		this.formats = formats;
	}


	public RightsList getRightsList() {
		return rightsList;
	}


	@XmlElement
	public void setRightsList(RightsList rightsList) {
		this.rightsList = rightsList;
	}


	public Creators getCreators() {
		return creators;
	}


	@XmlElement
	public void setCreators(Creators creators) {
		this.creators = creators;
	}


	public Subjects getSubjects() {
		return subjects;
	}


	@XmlElement
	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}


	public Dates getDates() {
		return dates;
	}


	@XmlElement
	public void setDates(Dates dates) {
		this.dates = dates;
	}


	public String getLanguage() {
		return language;
	}


	@XmlElement
	public void setLanguage(String language) {
		this.language = language;
	}


	public Titles getTitles() {
		return titles;
	}


	@XmlElement
	public void setTitles(Titles titles) {
		this.titles = titles;
	}


	public RelatedIdentifiers getRelatedIdentifiers() {
		return relatedIdentifiers;
	}


	@XmlElement
	public void setRelatedIdentifiers(RelatedIdentifiers relatedIdentifiers) {
		this.relatedIdentifiers = relatedIdentifiers;
	}


	public String getVersion() {
		return version;
	}


	@XmlElement
	public void setVersion(String version) {
		this.version = version;
	}


	public Descriptions getDescriptions() {
		return descriptions;
	}


	@XmlElement
	public void setDescriptions(Descriptions descriptions) {
		this.descriptions = descriptions;
	}


	public AlternateIdentifiers getAlternateIdentifiers() {
		return alternateIdentifiers;
	}


	@XmlElement
	public void setAlternateIdentifiers(AlternateIdentifiers alternateIdentifiers) {
		this.alternateIdentifiers = alternateIdentifiers;
	}


	public Sizes getSizes() {
		return sizes;
	}


	@XmlElement
	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}


	public String getPublisher() {
		return publisher;
	}


	@XmlElement
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPublicationYear() {
		return publicationYear;
	}


	@XmlElement
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}


	public Contributors getContributors() {
		return contributors;
	}


	@XmlElement
	public void setContributors(Contributors contributors) {
		this.contributors = contributors;
	}


	public FundingReferences getFundingReferences() {
		return fundingReferences;
	}


	@XmlElement
	public void setFundingReferences(FundingReferences fundingReferences) {
		this.fundingReferences = fundingReferences;
	}


	public ResourceType getResourceType() {
		return resourceType;
	}

	
	@XmlElement
	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}


	

	
	/**
	 * "Occurrence: 1 Datacite: This field aims to achieve the Train   principles
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 *
	 */
	public Train getTrain() {
		return train;
	}

	
	/**
	 * "Occurrence: 1 Datacite: This field aims to achieve the Train   principles
	 * 
	 * @author Joao Bosco Jares MSc. (Software Engineer)
	 * @see www.jbjares.com
	 * @see jbjares@gmail.com, joao.bosco.jares.alves.chaves@fit.fraunhofer.de
	 *
	 *
	 */
	@XmlElement
	public void setTrain(Train train) {
		this.train = train;
	}

	

	
	
	

}
