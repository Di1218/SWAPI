package swapi_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Search_for_Char_or_Planet {
	
	// API for searching a character or planet

		@Test
		public void TC_7_SearchFor_char_or_planet_validInput() {

			// specify a base or end point URL
			RestAssured.baseURI = "https://swapi.dev/api/";

			// create a request object
			RequestSpecification httpRequest = RestAssured.given();

			// create a response object
			Response httpResponse = httpRequest.request(Method.GET, "planets/?name=tatooine");

			// to make a response more readable, convert this response in a string
			String myResponse = httpResponse.getBody().asString();
			System.out.println(myResponse);

			// validate status code
			int myStatuscode = httpResponse.getStatusCode();
			System.out.println(myStatuscode);
	        // Verifying a status code with Assertion
			Assert.assertEquals(myStatuscode, 200);

			String myStatusline = httpResponse.getStatusLine();
			System.out.println(myStatusline);
	        // Verifying a status Line with Assertion
			Assert.assertEquals(myStatusline, "HTTP/1.1 200 OK");

		}

		@Test
		public void TC_8_SearchFor_char_or_planet_InvalidInput() {

			// specify a base or end point URL
			RestAssured.baseURI = "https://swapi.dev/api/";

			// create a request object
			RequestSpecification httpRequest = RestAssured.given();

			// create a response object
			Response httpResponse = httpRequest.request(Method.GET, "people/?name=534645%$%^6l");

			// to make a response more readable, convert this response in a string
			String myResponse = httpResponse.getBody().asString();
			System.out.println(myResponse);

			// validate status code
			int myStatuscode = httpResponse.getStatusCode();
			System.out.println(myStatuscode);
	        // Verifying a status code with Assertion
			Assert.assertEquals(myStatuscode, 404);

			String myStatusline = httpResponse.getStatusLine();
			System.out.println(myStatusline);
	        // Verifying a status Line with Assertion
			Assert.assertEquals(myStatusline, "HTTP/1.1 404 NOT FOUND");

		}
		
		@Test
		public void TC_9_SearchFor_char_or_planet_NullInput() {

			// specify a base or end point URL
			RestAssured.baseURI = "https://swapi.dev/api/";

			// create a request object
			RequestSpecification httpRequest = RestAssured.given();

			// create a response object
			Response httpResponse = httpRequest.request(Method.GET, "");

			// to make a response more readable, convert this response in a string
			String myResponse = httpResponse.getBody().asString();
			System.out.println(myResponse);

			// validate status code
			int myStatuscode = httpResponse.getStatusCode();
			System.out.println(myStatuscode);
	        // Verifying a status code with Assertion
			Assert.assertEquals(myStatuscode, 200);

			String myStatusline = httpResponse.getStatusLine();
			System.out.println(myStatusline);
	        // Verifying a status Line with Assertion
			Assert.assertEquals(myStatusline, "HTTP/1.1 200 OK");

		}


}
