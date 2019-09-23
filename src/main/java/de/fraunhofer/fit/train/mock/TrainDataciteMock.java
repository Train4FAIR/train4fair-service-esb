package de.fraunhofer.fit.train.mock;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import de.fraunhofer.fit.train.model.TrainWrapper;
import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Result;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
import de.fraunhofer.fit.train.model_v1.oci.Config;
import de.fraunhofer.fit.train.model_v1.oci.ExposedPorts;
import de.fraunhofer.fit.train.model_v1.oci.OCI;
import de.fraunhofer.fit.train.model_v2.doi.datacite.AlternateIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.AlternateIdentifiers;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Contributor;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Contributors;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Creator;
import de.fraunhofer.fit.train.model_v2.doi.datacite.CreatorName;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Creators;
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
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ArchitectureOCIEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.OsOciEnum;
import de.fraunhofer.fit.train.model_v2.nodered.Flow;
import de.fraunhofer.fit.train.model_v2.station.StationProfiles;
import de.fraunhofer.fit.train.util.TrainUtil;

@EnableAspectJAutoProxy
@Service
public class TrainDataciteMock {
	private static final String WEB_DAV = "WEB_DAV";

	private static final String INTERNAL_VERSION = "1.0.0";

	private static final String TRAIN_NAME = "TRAIN";

	private static final String FRAUNHOFER_INSTITUTE = "Fraunhofer Institute";

	public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	private static final String TRAIN_INTERNAL_ID = "54759eb3c090d83494e2d804";

	private static final String COMPUT_WAGON_INTERNAL_ID = "54759eb3c090d83494e2d808";

	private static final String HOLDER_ARTIFACT_RESOURCE_INTERNAL_ID = "54759eb3c090d83494e2d809";

	private static final String DOCKER_FILE_INTERNAL_ID = "54759eb3c090d83494e2d800";

	private static final String BUILD_FILE_INTERNAL_ID = "54759eb3c090d83494e2d810";

	private static final String SCRIPT_FILE_INTERNAL_ID = "54759eb3c090d83494e2d811";

	private static final String CQL_FILE_INTERNAL_ID = "54759eb3c090d83494e2d812";

	private static final String REQ_FILE_INTERNAL_ID = "54759eb3c090d83494e2d813";

	private static final String SOURCE_REPOSITORY_ID = "001596596676569964e2d899";

	private static final String USER_TOKEN = "001aad5965966eve7656c9964cee2d89v9";

	private static final String FLOW_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/basicNodeFlow.json";

	private static final String FLOW_URL = "https://pastebin.com/g4BdR0fN";

	private static final String DOI = "https://doi.org/10.1000/123";


	private Train getTrain() throws NoSuchAlgorithmException, IOException {
		Train train = new Train();
		train.setName("BMI Train.");
		train.setChecksum(calculateTrainChechsum(train));//
		train.setInternalId(TRAIN_INTERNAL_ID);//
		train.setInternalVersion(INTERNAL_VERSION);//
		train.setInternalPointer(TRAIN_NAME + TRAIN_INTERNAL_ID + INTERNAL_VERSION + SOURCE_REPOSITORY_ID);//
		train.setSourceRepository(SOURCE_REPOSITORY_ID);//
		File noderedWorkflow = new File(FLOW_FILE_LOCATION);//
		String internalPointer = train.getInternalPointer();
		train.setFlow(getFlow(noderedWorkflow,internalPointer));//
		train.setDescription("BMI Train for Test Purpose.");//
		train.setUserToken(USER_TOKEN);//
		train.setSimilarProjects(new String[] {"Project A", "Experiment 1", "Article xyz"});//
		train.setWagons(getWagons());//
		return train;
	}

	public TrainWrapper getExecutionTestTrain() throws NoSuchAlgorithmException, IOException {
		TrainWrapper trainWrapper = getTrainWrapper();
		trainWrapper.setTrain(getTrain());
		return trainWrapper;
	}
	
	
	private Flow getFlow(File noderedWorkflow, String id) throws IOException, NoSuchAlgorithmException {
		Flow flow = new Flow();
		flow.setFlowID("e3be62f1.a8031");
		flow.setFlowURL("http://127.0.0.1:9091/RepositoryService/train/5d87fbacca90820801b0eba0");
		flow.setDescription("Some Description.");
		return flow;
	}

	private Wagons[] getWagons() throws NoSuchAlgorithmException, IOException {
		Wagons wagons = new Wagons();
		wagons.setDescription("Some Description.");
		wagons.setName("BMI Orchestration Computing Wagon");
		wagons.setStationProfiles(getStationProfiles());
		wagons.setResources(getResources());
		
		Result result = new Result();
		result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 101");
		result.setMeanAgeCohortResult("Mean age in cohort: 37.992222567222333");
		result.setPatientCohortFor("Patient cohort for Obesity, Obesity, Diabetes");
		result.setRetrievedCohortSize("Retrieved cohort size 666");
		wagons.setResult(result);
		
		return new Wagons[] { wagons };
	}

	private StationProfiles getStationProfiles() {
		StationProfiles stationProfiles = new StationProfiles();
		stationProfiles.setStationProfile(new String[] {"DIABETES", "DIABETES", "DIABETES"});
		return stationProfiles;
	}


	private Resources[] getResources() throws NoSuchAlgorithmException, IOException {
		
		Resources resources = new Resources();
		resources.setName("OCI Resource1");
		resources.setDescription("Resource to Organise and Configure the Artifacts1");
		resources.setOci(getOCI());
		resources.setArtifacts(getArtifacts());

		return new Resources[] { resources};
	}

	private Artifacts[] getArtifacts() throws NoSuchAlgorithmException, IOException {

		return new Artifacts[] { getDockerfile(), getBuildFile(), getScriptFile(), getCQLFile(),
				getRequirements() };
	}

	private Artifacts getDockerfile() throws NoSuchAlgorithmException, IOException {
		Artifacts requirements = new Artifacts();
		requirements.setName("Dockerfile");
		File reqFile = new File(
				"/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/Dockerfile");
		requirements.setChecksum(TrainUtil.getChecksum(reqFile));
		requirements.setFilename("Dockerfile");
		requirements.setFileUrl("http://138.68.75.16:8080/webdav/train/Dockerfile");
		requirements.setFormat(StandardCharsets.UTF_8.toString());
		return requirements;
	}

	private Artifacts getRequirements() throws NoSuchAlgorithmException, IOException {
		Artifacts requirements = new Artifacts();
		requirements.setName("requirements");
		File reqFile = new File(
				"/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/requirements.txt");
		requirements.setChecksum(TrainUtil.getChecksum(reqFile));
		requirements.setFilename("requirements.txt");
		requirements.setFileUrl("http://138.68.75.16:8080/webdav/train/requirements.txt");
		requirements.setFormat(StandardCharsets.UTF_8.toString());
		return requirements;
	}

	private Artifacts getCQLFile() throws NoSuchAlgorithmException, IOException {
		Artifacts cql = new Artifacts();
		cql.setName("CQL");
		File cqldFile = new File(
				"/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/input2.cql");
		cql.setChecksum(TrainUtil.getChecksum(cqldFile));
		cql.setFilename("input2.cql");
		cql.setFormat(StandardCharsets.UTF_8.toString());
		cql.setFileUrl("http://138.68.75.16:8080/webdav/train/input2.cql");
		return cql;
	}

	private Artifacts getScriptFile() throws IOException, NoSuchAlgorithmException {
		Artifacts script = new Artifacts();
		script.setName("script");
		File scriptFile = new File(
				"/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/script.py");
		script.setChecksum(TrainUtil.getChecksum(scriptFile));
		script.setFilename("script.py");
		script.setFileUrl("http://138.68.75.16:8080/webdav/train/script.py");
		script.setFormat(StandardCharsets.UTF_8.toString());
		return script;
	}

	private Artifacts getBuildFile() throws IOException, NoSuchAlgorithmException {
		Artifacts build = new Artifacts();
		build.setName("build");
		File buildFile = new File(
				"/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/build.sh");
		build.setChecksum(TrainUtil.getChecksum(buildFile));
		build.setFileUrl("http://138.68.75.16:8080/webdav/train/build.sh");
		build.setFilename("build.sh");
		build.setFormat(StandardCharsets.UTF_8.toString());
		return build;
	}

	private String calculateTrainChechsum(Train train) throws NoSuchAlgorithmException, IOException {
		return TrainUtil.getChecksum(train);
	}

	private OCI getOCI() {
		OCI oci = new OCI();
		oci.setArchitecture(ArchitectureOCIEnum.AMD64.getText());
		oci.setOs(OsOciEnum.LINUX.getText());
		oci.setAuthor("Linus");
		oci.setCreated(new Date().toString());
		oci.setConfig(getOCIConfig());
		return oci;
	}

	private Config getOCIConfig() {
		Config config = new Config();
		config.setUser(getCIUser());
		config.setUser("jbjares@gmail.com");
		config.setCmd(new String[] {"Some special command, if necessary1","Some special command, if necessary1"});
		config.setEntrypoint(new String[] {"An array of entrypoints1","An array of entrypoints2"});
		config.setEnv(new String[] {"A group of environment requirements to run the generated image1","A group of environment requirements to run the generated image2"});
		ExposedPorts exposedPorts = new ExposedPorts();
		exposedPorts.setPort("80");
		exposedPorts.setProtocol("HTTP");
		config.setExposedPort(new ExposedPorts[] {exposedPorts});
		config.setVolumes(new String[] {"A Group of volumes if necessary1","A Group of volumes if necessary2"});
		return config;
	}

	private String getCIUser() {
		return "jbjares@gmail.com";
	}
///
	private  TrainWrapper getTrainWrapper() {
		TrainWrapper wrapper = new TrainWrapper();
		// ==
		Identifier identifier = new Identifier();
		identifier.setContent("10.5072/example-full");
		identifier.setIdentifierType("DOI");
		wrapper.setIdentifier(identifier);

		// ==
		Creators creators = new Creators();
		Creator creator = new Creator();
		creator.setAffiliation("DataCite");
		CreatorName creatorName = new CreatorName();
		creatorName.setNameType("Personal");
		creatorName.setContent("Miller, Elizabeth");
		creator.setCreatorName(creatorName);
		creator.setGivenName("Elizabeth");
		creator.setFamilyName("Miller");
		NameIdentifier nameIdentifier = new NameIdentifier();
		nameIdentifier.setContent("0000-0001-5000-0007");
		nameIdentifier.setSchemeURI("http://orcid.org/");
		nameIdentifier.setNameIdentifierScheme("ORCID");
		creator.setNameIdentifier(nameIdentifier);
		
		Creator creator2 = new Creator();
		creator2.setAffiliation("DataCite");
		CreatorName creatorName2 = new CreatorName();
		creatorName2.setNameType("Personal");
		creatorName2.setContent("Miller, Elizabeth");
		creator2.setCreatorName(creatorName);
		creator2.setGivenName("Elizabeth");
		creator2.setFamilyName("Miller");
		creators.setCreator(new Creator[] { creator,creator2 });
		NameIdentifier nameIdentifier2 = new NameIdentifier();
		nameIdentifier2.setContent("0000-0001-5000-0007");
		nameIdentifier2.setSchemeURI("http://orcid.org/");
		nameIdentifier2.setNameIdentifierScheme("ORCID");
		creator.setNameIdentifier(nameIdentifier2);
		wrapper.setCreators(creators);
		// ==
		Titles titles = new Titles();
		Title title1 = new Title();
		title1.setXml("en-US");
		title1.setContent("Full DataCite XML Example");
		Title title2 = new Title();
		title2.setXml("en-US");
		title2.setTitleType("Subtitle");
		title2.setContent("Demonstration of DataCite Properties.");
		titles.setTitle(new Title[] { title1, title2 });
		wrapper.setTitles(titles);
		// ==
		wrapper.setPublisher("DataCite");
		wrapper.setPublicationYear("2014");
		// ==
		Subjects subjects = new Subjects();
		Subject subject = new Subject();
		subject.setContent("000 computer science");
		subject.setSchemeURI("http://dewey.info/");
		subject.setSubjectScheme("dewey");
		subject.setXml("en-US");
		
		Subject subject2 = new Subject();
		subject2.setContent("000 computer science");
		subject2.setSchemeURI("http://dewey.info/");
		subject2.setSubjectScheme("dewey");
		subject2.setXml("en-US");
		
		subjects.setSubject(new Subject[] { subject,subject2 });
		wrapper.setSubjects(subjects);
		// ==
		Contributors contributors = new Contributors();
		Contributor contributor = new Contributor();
		contributor.setAffiliation("California Digital Library");
		contributor.setContributorName("Starr, Joan");
		contributor.setContributorType("ProjectLeader");
		contributor.setFamilyName("Starr");
		contributor.setGivenName("Joan");
		NameIdentifier nameIdentifier0 = new NameIdentifier();
		nameIdentifier0.setContent("0000-0002-7285-027X");
		nameIdentifier0.setNameIdentifierScheme("ORCID");
		nameIdentifier0.setSchemeURI("http://orcid.org/");
		contributor.setNameIdentifier(nameIdentifier0);
		
		Contributor contributor2 = new Contributor();
		contributor2.setAffiliation("California Digital Library");
		contributor2.setContributorName("Starr, Joan");
		contributor2.setContributorType("ProjectLeader");
		contributor2.setFamilyName("Starr");
		contributor2.setGivenName("Joan");
		NameIdentifier nameIdentifier1 = new NameIdentifier();
		nameIdentifier1.setContent("0000-0002-7285-027X");
		nameIdentifier1.setNameIdentifierScheme("ORCID");
		nameIdentifier1.setSchemeURI("http://orcid.org/");
		contributor2.setNameIdentifier(nameIdentifier1);
		contributors.setContributor(new Contributor[] { contributor,contributor2 });
		wrapper.setContributors(contributors);
		// ==
		Dates dates = new Dates();
		Date date = new Date();
		date.setContent("2017-09-13");
		date.setDateInformation("Updated with 4.1 properties");
		date.setDateType("Updated");
		
		Date date1 = new Date();
		date1.setContent("2017-09-13");
		date1.setDateInformation("Updated with 4.1 properties");
		date1.setDateType("Updated");
		
		dates.setDate(new Date[] { date,date1 });
		wrapper.setDates(dates);
		// ==
		wrapper.setLanguage("en-US");
		// ==
		ResourceType resourceType = new ResourceType();
		resourceType.setContent("XML");
		resourceType.setResourceTypeGeneral("Software");
		wrapper.setResourceType(resourceType);
		// ==
		AlternateIdentifiers alternateIdentifiers = new AlternateIdentifiers();
		AlternateIdentifier alternateIdentifier = new AlternateIdentifier();
		alternateIdentifier.setAlternateIdentifierType("URL");
		alternateIdentifier
				.setContent("https://schema.datacite.org/meta/kernel-4.1/example/datacite-example-full-v4.1.xml");
		
		AlternateIdentifier alternateIdentifier1 = new AlternateIdentifier();
		alternateIdentifier1.setAlternateIdentifierType("URL");
		alternateIdentifier1
				.setContent("https://schema.datacite.org/meta/kernel-4.1/example/datacite-example-full-v4.1.xml");
		
		alternateIdentifiers.setAlternateIdentifier(new AlternateIdentifier[] { alternateIdentifier,alternateIdentifier1 });
		wrapper.setAlternateIdentifiers(alternateIdentifiers);
		// ==
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
		relatedIdentifiers.setRelatedIdentifier(new RelatedIdentifier[] { relatedIdentifier1, relatedIdentifier2 });
		wrapper.setRelatedIdentifiers(relatedIdentifiers);
		// ==
		Sizes sizes = new Sizes();
		Size size1 = new Size();
		Size size2 = new Size();
		size1.setContent("1kb");
		size2.setContent("1MB");
		sizes.setSize(new Size[] {size1,size2});
		wrapper.setSizes(sizes);
		// ==
		Formats formats = new Formats();
		Format format1 = new Format();
		format1.setContent("application/json");
		Format format2 = new Format();
		format2.setContent("application/xml");
		formats.setFormat(new Format[] {format1, format2});
		wrapper.setFormats(formats);
		// ==
		wrapper.setVersion("4.1");
		// ==
		RightsList rightsList = new RightsList();
		Rights rights = new Rights();
		rights.setContent("CC0 1.0 Universal");
		rights.setRightsURI("http://creativecommons.org/publicdomain/zero/1.0/");
		rights.setXml("en-US");
		
		Rights rights1 = new Rights();
		rights1.setContent("CC0 1.0 Universal2");
		rights1.setRightsURI("http://creativecommons.org/publicdomain/zero/1.0/2");
		rights1.setXml("en-US");
		
		rightsList.setRights(new Rights[] { rights,rights1 });
		wrapper.setRightsList(rightsList);
		// ==
		Descriptions descriptions = new Descriptions();
		Description description = new Description();
		description.setXml("en-US");
		description.setContent("XML example of all DataCite Metadata Schema v4.1 properties.");
		description.setDescriptionType("Abstract");
		
		Description description2 = new Description();
		description2.setXml("en-US");
		description2.setContent("XML example of all DataCite Metadata Schema v4.1 properties2");
		description2.setDescriptionType("seriesinformation");
		
		descriptions.setDescription(new Description[] { description,description2 });
		wrapper.setDescriptions(descriptions);
		// ==
		FundingReferences fundingReferences = new FundingReferences();
		FundingReference fundingReference = new FundingReference();
		fundingReference.setAwardNumber("CBET-106");
		fundingReference.setAwardTitle("Full DataCite XML Example");
		fundingReference.setFunderName("National Science Foundation");
		FunderIdentifier funderIdentifier = new FunderIdentifier();
		funderIdentifier.setContent("https://doi.org/10.13039/100000001");
		funderIdentifier.setFunderIdentifierType("Crossref Funder ID");
		fundingReference.setFunderIdentifier(funderIdentifier);
		
		FundingReference fundingReference2 = new FundingReference();
		fundingReference2.setAwardNumber("CBET-106");
		fundingReference2.setAwardTitle("Full DataCite XML Example");
		fundingReference2.setFunderName("National Science Foundation");
		FunderIdentifier funderIdentifier2 = new FunderIdentifier();
		funderIdentifier2.setContent("https://doi.org/10.13039/100000001");
		funderIdentifier2.setFunderIdentifierType("Crossref Funder ID");
		fundingReference2.setFunderIdentifier(funderIdentifier);
		fundingReferences.setFundingReference(new FundingReference[] { fundingReference,fundingReference2 });
		wrapper.setFundingReferences(fundingReferences);
		return wrapper;
	}



}
