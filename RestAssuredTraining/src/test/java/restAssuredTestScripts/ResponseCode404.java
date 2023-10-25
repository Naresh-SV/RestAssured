package restAssuredTestScripts;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ResponseCode404 {

	@Test
	void verify404ResponseCode() {
		given()
			.contentType("application/json")
			.pathParam("path1", "entries1")	//exact path parameter is entries.
		.when()
			.get("https://api.publicapis.org/{path1}")
		.then()
//			.log().all()
			.log().everything(true)
			.statusCode(404);
		
	}
}
