package de.fraunhofer.fit.train.services.exposed;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.model_v1.Train;

@EnableAspectJAutoProxy
@RestController
@Service
public class ExposedServiceInterfaces {

	@Autowired
	private ServiceFacade facade;

	@Autowired
	private MongoOperations mongoOperations;


	@GetMapping(value = "/train/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
	Train getTrainById(@PathVariable String trainId) throws NoSuchAlgorithmException, IOException, Exception {
		Train train = facade.findTrainByInternalId(trainId);
		return train;
	}

	@GetMapping(value = "/train/attribute/{someProperty}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Train> getAllTrains(@PathVariable String someProperty) throws NoSuchAlgorithmException, IOException, Exception {
		List<Train> trainlist = facade.findOneByRegexQuery(someProperty);
		return trainlist;
	}

	@GetMapping(value = "/train/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Train> getAllTrains() throws NoSuchAlgorithmException, IOException, Exception {
		List<Train> trainlist = mongoOperations.findAll(Train.class);
		return trainlist;
	}

}
