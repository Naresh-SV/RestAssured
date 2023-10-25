package restAssuredTestScripts;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesValidation {
	
	@Test
	void cookieValidation() {
//		JSONObject data=new JSONObject();
//		data.put("name", "Naresh");
//		data.put("job", "Engineer");
		Response res=
		given()
			.contentType("application/json")
//			.body(data)
		.when()
			.get("https://google.com/");
		
		Map<String,String> cookies=res.getCookies();
		for(String k:cookies.keySet()) {
//			String Cookie=res.getCookie(k);
			System.out.println(k+"    "+cookies.get(k));
		}
	}

}
