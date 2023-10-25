package restAssuredTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ResponseValidation {
	int id;
	@Test(priority=1)
	void restAssuAssertionredValidation() {		
		given()
			.contentType("application/json")
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8");
		
	}

	@Test(priority=1)
	void testNGAssertionValidation() {		
		Response res=given()
			.contentType("application/json")
		.when()
			.get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		System.out.println(res.getHeader("Content-Type"));
		System.out.println(res.header("Content-Type"));
		
	}
}
