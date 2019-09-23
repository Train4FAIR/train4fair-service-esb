package de.fraunhofer.fit.train.mock;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Result;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
import de.fraunhofer.fit.train.model_v1.oci.Config;
import de.fraunhofer.fit.train.model_v1.oci.ExposedPorts;
import de.fraunhofer.fit.train.model_v1.oci.OCI;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Date;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ArchitectureOCIEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.OsOciEnum;
import de.fraunhofer.fit.train.model_v2.nodered.Flow;
import de.fraunhofer.fit.train.model_v2.station.StationProfiles;
import de.fraunhofer.fit.train.util.TrainUtil;

@EnableAspectJAutoProxy
@Service
public class TrainMock {

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


	public Train getTrain() throws NoSuchAlgorithmException, IOException {
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
		
		Resources artifact1 = new Resources();
		artifact1.setName("OCI Resource1");
		artifact1.setDescription("Resource to Organise and Configure the Artifacts1");
		artifact1.setOci(getOCI());
		artifact1.setArtifacts(getArtifacts());
		
		Resources artifact2 = new Resources();
		artifact2.setName("OCI Resource2");
		artifact2.setDescription("Resource to Organise and Configure the Artifacts2");
		artifact2.setOci(getOCI());
		artifact2.setArtifacts(getArtifacts());
		return new Resources[] { artifact1,artifact2 };
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



}
