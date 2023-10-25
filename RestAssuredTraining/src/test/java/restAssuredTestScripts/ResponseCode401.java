package restAssuredTestScripts;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ResponseCode401 {

	@Test
	void validate401ResponseCode() {
		HashMap data=new HashMap();
		data.put("name", "test");
		data.put("job", "automation");
		
		given()
			.contentType("application/json")
			.pathParam("path", "createData")
			.body(data)
		.when()
			.post("https://apiautomationtesting.free.beeceptor.com/{path}")
		.then()
			.log().all()
			.statusCode(200)
			.contentType("application/json");
	}
}
