package restAssuredTestScripts;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderValidation {
	@Test
	void cookieValidation() {

		Response res=
		given()
			.contentType("application/json")
		.when()
			.get("https://google.com/");
		
		Headers headers=res.getHeaders();
		for(Header h:headers) {
			System.out.println(h.getName()+"   "+h.getValue());
		}
	}

}
