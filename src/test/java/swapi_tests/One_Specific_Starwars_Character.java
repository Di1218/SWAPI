package swapi_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class One_Specific_Starwars_Character {
	// APIfor retrieving one specific Starwars character

		@Test
		public void TC_04_OneSpecific_StarWars_char_validInput() {

			// specify a base or end point URL
			RestAssured.baseURI = "https://swapi.dev/api/";

			// create a request object
			RequestSpecification httpRequest = RestAssured.given();

			// create a response object
			Response httpResponse = httpRequest.request(Method.GET, "people/?name=Luke");

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
		public void TC_05_OneSpecific_StarWars_char_InvalidInput() {

			// specify a base or end point URL
			RestAssured.baseURI = "https://swapi.dev/api/";

			// create a request object
			RequestSpecification httpRequest = RestAssured.given();

			// create a response object
			Response httpResponse = httpRequest.request(Method.GET, "people/105/");

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
		public void TC_06_OneSpecific_StarWars_char_NullInput() {

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
