package de.fraunhofer.fit.train.services.exposed;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.factory.TrainFactory;
import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Result;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Datacite;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Identifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RelatedIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ArchitectureOCIEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ContributorTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.DateTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.DescriptionTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.FunderIdentifierTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.IdentifierTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.LanguageDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.NameIdentifierSchemeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.NameTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.OsOciEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.RelatedIdentifierTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.RelationTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ResourceTypeGeneralDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.StationProfileEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.TitleTypeDataciteEnum;
import de.fraunhofer.fit.train.util.TrainUtil;

@EnableAspectJAutoProxy
@RestController
@Service
public class ExposedServiceInterfaces {

	@Autowired
	private ServiceFacade facade;

	@Autowired
	private MongoOperations mongoOperations;



	@GetMapping(value = "/train/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
	//!!!
	Train getTrainById(@PathVariable String trainId) throws NoSuchAlgorithmException, IOException, Exception {
		Train train = facade.findTrainByInternalId(trainId);
		return train;
	}

	@GetMapping(value = "/train/all", produces = MediaType.APPLICATION_JSON_VALUE)
	//!!!
	List<Train> getAllTrains() throws NoSuchAlgorithmException, IOException, Exception {
		List<Train> trainlist = mongoOperations.findAll(Train.class);
		return trainlist;
	}



}
