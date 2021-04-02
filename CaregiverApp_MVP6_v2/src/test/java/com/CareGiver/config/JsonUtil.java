package com.CareGiver.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.CareGiver.domains.Session;
import com.CareGiver.supportLibraries.Util;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

	public static final String SESSION_JSON = "session.json";

	public void createSessionJsonOutput(List<Session> sessions) {
		ObjectMapper mapper = new ObjectMapper();
		// Session session = new Session();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {

			// Convert object to JSON string and save into a file directly
			//mapper.writeValue(new File(Util.getJSONOutputPath() + Util.getFileSeparator() + SESSION_JSON), session);
			
			// Convert object to JSON string String jsonInString =
			String jsonInString = mapper.writeValueAsString(sessions);
			
			//2. Convert JSON to List of Person objects
	    	//Define Custom Type reference for List<Person> type
	    	TypeReference<List<Session>> mapType = new TypeReference<List<Session>>() {};
	    	List<Session> jsonToSessionList = mapper.readValue(jsonInString, mapType);
	    	System.out.println("\n2. Convert JSON to List of Session objects :");
	    	
	    	//Print list of session objects output using Java 8
	    	jsonToSessionList.forEach(System.out::println);
			

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
