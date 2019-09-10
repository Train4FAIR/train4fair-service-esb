package de.fraunhofer.fit.train.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurlExecutor {

	public static void execute(String username, String password,String path) {


		
		//cURL Command: curl -u admin:admin -X POST -F cmd="lockPage" -F path="/content/geometrixx/en/toolbar/contacts" -F "_charset_"="utf-8" http://localhost:4502/bin/wcmcommand
		//curl -X POST -H \"Content-Type: application/vnd.api+json\" --user DEV.FIT:Nahan@123 -d @my_draft_doi.json https://api.test.datacite.org/dois -iv"
		//Equivalent command conversion for Java execution
		String[] command = { "curl", "-X POST -H","Content-Type:","application/vnd.api+json,"+
		"--user "+username + ":" + password +
				"-d","@"+ path, "https://api.test.datacite.org/dois", "-iv"};

		ProcessBuilder process = new ProcessBuilder(command);
		Process p;
		try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			System.out.print(result);

		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}
	}

	

}
