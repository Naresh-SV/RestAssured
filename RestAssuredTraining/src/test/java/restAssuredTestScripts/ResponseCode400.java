package restAssuredTestScripts;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ResponseCode400 {

	@Test
	void responseCode400Validation() {
		HashMap data=new HashMap();
		data.put("name", "test");
		data.put("purpose", "APITesting");
		
		given()
			.contentType("application/json")
			.pathParam("myPath", "UserDataBadRequest")
			.body(data)
			.log().body().log().headers().log().uri()
		.when()
			.post("https://apiautomationtesting.free.beeceptor.com/{myPath}")
		.then()
			.log().everything()
			.statusCode(400);
	}
}
