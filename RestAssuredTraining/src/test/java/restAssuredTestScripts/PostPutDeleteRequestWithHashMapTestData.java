package restAssuredTestScripts;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostPutDeleteRequestWithHashMapTestData {
	int ID;
	@Test(priority=1)
	void postRequestValidation() {
		HashMap data=new HashMap();
		data.put("name","Naresh");
		data.put("job", "Software");
		
		Response rs=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users");
		
		ID=rs.getBody().jsonPath().getInt("id");
	}
	
	@Test(priority=2, dependsOnMethods={"postRequestValidation"})
	void updatePreviousRequest() {
		HashMap data=new HashMap();
		data.put("name","Naresh");
		data.put("job", "Software Engineer");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+ID)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods={"updatePreviousRequest"})
	void deleteMethodValidation() {
		given()
			.contentType("application/json")
		.when()
			.delete("https://reqres.in/api/users/"+ID)
		.then()
			.statusCode(204)
			.log().all();
	}

}
