package de.fraunhofer.fit.train.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TrainFactory {
	
	public static Gson getGson() {
	    final Gson gson = new GsonBuilder()
	            .excludeFieldsWithoutExposeAnnotation()
	            .disableHtmlEscaping()
	            .generateNonExecutableJson()
	            .setLenient()
	            .create();
	    return gson;
	}

}
