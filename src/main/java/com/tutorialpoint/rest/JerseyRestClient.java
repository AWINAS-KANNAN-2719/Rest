package com.tutorialpoint.rest;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.tutorialpoint.rest.Bean.User;

public class JerseyRestClient {

	static String BASE_URL = "http://localhost:8080/Rest/rest/";

	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource resource = client.resource(BASE_URL + "user/getAllUsers");
			ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
			ClientResponse response1 = resource.accept("application/xml").get(ClientResponse.class);

			/*
			 * System.out.println(response.getHeaders().keySet());
			 * System.out.println(response.getMetadata().keySet());
			 * System.out.println(response.getHeaders().get("Content-Type"));
			 * System.out.println(response.getClientResponseStatus().getStatusCode());
			 * System.out.println(); System.out.println(response.getLanguage() +
			 * response.getLocation());
			 */
			if (response.getStatus() == 200) {

				String output = response.getEntity(String.class);
				System.out.println(output);

				String output1 = response1.getEntity(String.class);
				System.out.println(output1);

				GenericType<List<User>> list = new GenericType<List<User>>() {
				};

				List<User> users = resource.get(list);
				System.out.println(users);

			} else
				System.out.println("Somthing went wrong..!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
