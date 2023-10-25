package restAssuredTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReadResponseUsingJSONPath {
	
	@Test
	void readResponseUsingJSONPath() {
		Response res=given()
			.contentType("application/json")
		.when()
			.get("https://reqres.in/api/unknown");
		System.out.println("===========");
		System.out.println(res.asPrettyString());		//prints the whole response body
		System.out.println("===========");
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(res.jsonPath().get("data[2].name").toString());
		Assert.assertEquals(res.jsonPath().get("data[2].name").toString(),"true red");
	}

}
