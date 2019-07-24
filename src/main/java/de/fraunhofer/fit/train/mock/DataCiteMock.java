package de.fraunhofer.fit.train.mock;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import de.fraunhofer.fit.train.model_v2.doi.datacite.AlternateIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.AlternateIdentifiers;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Contributor;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Contributors;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Creator;
import de.fraunhofer.fit.train.model_v2.doi.datacite.CreatorName;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Creators;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Datacite;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Date;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Dates;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Description;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Descriptions;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Format;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Formats;
import de.fraunhofer.fit.train.model_v2.doi.datacite.FunderIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.FundingReference;
import de.fraunhofer.fit.train.model_v2.doi.datacite.FundingReferences;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Identifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.NameIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RelatedIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RelatedIdentifiers;
import de.fraunhofer.fit.train.model_v2.doi.datacite.ResourceType;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Rights;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RightsList;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Size;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Sizes;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Subject;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Subjects;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Title;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Titles;


@EnableAspectJAutoProxy
@Service
public class DataCiteMock {
	
///	
	public Datacite getDataCite() {
		Datacite resource = new Datacite();
		//==
		Identifier identifier = new Identifier();
		identifier.setContent("10.5072/example-full");
		identifier.setIdentifierType("DOI");
		resource.setIdentifier(identifier);
		//==
		Creators creators = new Creators();
		Creator creator = new Creator();
		creator.setAffiliation("DataCite");
		CreatorName creatorName = new CreatorName();
		creatorName.setNameType("Personal");
		creatorName.setContent("Miller, Elizabeth");
		creator.setCreatorName(creatorName);
		creator.setGivenName("Elizabeth");
		creator.setFamilyName("Miller");
		creators.setCreator(new Creator[] {creator});
		NameIdentifier nameIdentifier = new NameIdentifier();
		nameIdentifier.setContent("0000-0001-5000-0007");
		nameIdentifier.setSchemeURI("http://orcid.org/");
		nameIdentifier.setNameIdentifierScheme("ORCID");
		creator.setNameIdentifier(nameIdentifier);
		resource.setCreators(creators);
		//==
		Titles titles = new Titles();
		Title title1 = new Title();
		title1.setXml("en-US");
		title1.setContent("Full DataCite XML Example");
		Title title2 = new Title();
		title2.setXml("en-US");
		title2.setTitleType("Subtitle");
		title2.setContent("Demonstration of DataCite Properties.");
		titles.setTitle(new Title[] {title1,title2});
		resource.setTitles(titles);
		//==
		resource.setPublisher("DataCite");
		resource.setPublicationYear("2014");
		//==
		Subjects subjects = new Subjects();
		Subject subject = new Subject();
		subject.setContent("000 computer science");
		subject.setSchemeURI("http://dewey.info/");
		subject.setSubjectScheme("dewey");
		subject.setXml("en-US");
		subjects.setSubject(new Subject[] {subject});
		resource.setSubjects(subjects);
		//==
		Contributors contributors = new Contributors();
		Contributor contributor = new Contributor();
		contributor.setAffiliation("California Digital Library");
		contributor.setContributorName("Starr, Joan");
		contributor.setContributorType("ProjectLeader");
		contributor.setFamilyName("Starr");
		contributor.setGivenName("Joan");
		NameIdentifier nameIdentifier2 = new NameIdentifier();
		nameIdentifier2.setContent("0000-0002-7285-027X");
		nameIdentifier2.setNameIdentifierScheme("ORCID");
		nameIdentifier2.setSchemeURI("http://orcid.org/");
		contributor.setNameIdentifier(nameIdentifier2);
		contributors.setContributor(new Contributor[] {contributor});
		resource.setContributors(contributors);
		//==
		Dates dates = new Dates();
		Date date = new Date();
		date.setContent("2017-09-13");
		date.setDateInformation("Updated with 4.1 properties");
		date.setDateType("Updated");
		dates.setDate(new Date[] {date});
		resource.setDates(dates);
		//==
		resource.setLanguage("en-US");
		//==
		ResourceType resourceType = new ResourceType();
		resourceType.setContent("XML");
		resourceType.setResourceTypeGeneral("Software");
		resource.setResourceType(resourceType);
		//==
		AlternateIdentifiers alternateIdentifiers = new AlternateIdentifiers();
		AlternateIdentifier alternateIdentifier = new AlternateIdentifier();
		alternateIdentifier.setAlternateIdentifierType("URL");
		alternateIdentifier.setContent("https://schema.datacite.org/meta/kernel-4.1/example/datacite-example-full-v4.1.xml");
		alternateIdentifiers.setAlternateIdentifier(new AlternateIdentifier[] {alternateIdentifier});
		resource.setAlternateIdentifiers(alternateIdentifiers);
		//==
		RelatedIdentifiers relatedIdentifiers = new RelatedIdentifiers();
		RelatedIdentifier relatedIdentifier1 = new RelatedIdentifier();
		relatedIdentifier1.setContent("https://data.datacite.org/application/citeproc+json/10.5072/example-full");
		relatedIdentifier1.setRelatedIdentifierType("URL");
		relatedIdentifier1.setRelatedMetadataScheme("citeproc+json");
		relatedIdentifier1.setRelationType("HasMetadata");
		relatedIdentifier1.setSchemeURI("https://github.com/citation-style-language/schema/raw/master/csl-data.json");
		//
		RelatedIdentifier relatedIdentifier2 = new RelatedIdentifier();
		relatedIdentifier2.setRelatedIdentifierType("arXiv");
		relatedIdentifier2.setRelationType("IsReviewedBy");
		relatedIdentifier2.setResourceTypeGeneral("Text");
		relatedIdentifier2.setContent("arXiv:0706.0001");
		relatedIdentifiers.setRelatedIdentifier(new RelatedIdentifier[] {relatedIdentifier1,relatedIdentifier2});
		resource.setRelatedIdentifiers(relatedIdentifiers);
		//==
		Sizes sizes = new Sizes();
		Size size1 = new Size();
		Size size2 = new Size();
		size1.setContent("1kb");
		size2.setContent("1MB");
		sizes.setSize(new Size[] {size1,size2});
		resource.setSizes(sizes);
		//==
		Formats formats = new Formats();
		Format format1 = new Format();
		format1.setContent("application/json");
		Format format2 = new Format();
		format2.setContent("application/xml");
		formats.setFormat(new Format[] {format1, format2});
		resource.setFormats(formats);
		//==
		resource.setVersion("4.1");
		//==
		RightsList rightsList = new RightsList();
		Rights rights = new Rights();
		rights.setContent("CC0 1.0 Universal");
		rights.setRightsURI("http://creativecommons.org/publicdomain/zero/1.0/");
		rights.setXml("en-US");
		rightsList.setRights(new Rights[] {rights});
		resource.setRightsList(rightsList);
		//==
		Descriptions descriptions = new Descriptions();
		Description description = new Description();
		description.setXml("en-US");
		description.setContent("XML example of all DataCite Metadata Schema v4.1 properties.");
		description.setDescriptionType("Abstract");
		descriptions.setDescription(new Description[] {description});
		resource.setDescriptions(descriptions);
		//==
		FundingReferences fundingReferences = new FundingReferences();
		FundingReference fundingReference = new FundingReference();
		fundingReference.setAwardNumber("CBET-106");
		fundingReference.setAwardTitle("Full DataCite XML Example");
		fundingReference.setFunderName("National Science Foundation");
		FunderIdentifier funderIdentifier = new FunderIdentifier();
		funderIdentifier.setContent("https://doi.org/10.13039/100000001");
		funderIdentifier.setFunderIdentifierType("Crossref Funder ID");
		fundingReference.setFunderIdentifier(funderIdentifier);
		fundingReferences.setFundingReference(new FundingReference[] {fundingReference});
		resource.setFundingReferences(fundingReferences);
		return resource;
		
	}

}
