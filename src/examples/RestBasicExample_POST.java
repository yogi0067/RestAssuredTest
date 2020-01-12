package examples;
//it will have both example to add place and delete place from google map
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class RestBasicExample_POST {
	@Test
	public void RestTest1() {
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res= given().
			queryParam("key", "qaclick123").
			body("{\r\n" + 
					"    \"location\":{\r\n" + 
					"        \"lat\" : -38.383494,\r\n" + 
					"        \"lng\" : 33.427362\r\n" + 
					"    },\r\n" + 
					"    \"accuracy\":50,\r\n" + 
					"    \"name\":\"Frontline house\",\r\n" + 
					"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
					"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
					"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
					"    \"website\" : \"http://google.com\",\r\n" + 
					"    \"language\" : \"French-IN\"\r\n" + 
					"}\r\n" + 
					"").
		when().
			post("/maps/api/place/add/json").
		then().
		assertThat().
		body("status",equalTo("OK")).extract().response();
		
		String resResultStr=res.asString();
		System.out.println(resResultStr);
		JsonPath jsonData= new JsonPath(resResultStr);
		String place_id = jsonData.get("place_id");
		System.out.println("place_id" + place_id);
		
		
		
		
		given().
			queryParam("key", "qaclick123").
			body("{\r\n" + 
					"	\"place_id\": \""+place_id+"\"\r\n" + 
					"}").
		when().
			post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().body("status", equalTo("OK"));
		
		
		
		
		
		
		
		
		
			
				
	}

}
