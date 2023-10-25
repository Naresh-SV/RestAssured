package restAssuredTestScripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class POJOTesting {
	
	@Test(priority=1)
	void pojoTesting() {
		POJOTestData data=new POJOTestData();
		data.setEmail("eve.holt@reqres.in");
		data.setPassword("pistol");
		
		given()
			.contentType("application/json")
			.body(data)
			.log().body()
		.when()
			.post("https://reqres.in/api/register")
		.then()
			.statusCode(200);
	}

}
