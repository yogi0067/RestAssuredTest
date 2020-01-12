package examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class RestBasicExample_GET {
	@Test
	public void RestTest1() {
		RestAssured.baseURI="https://maps.googleapis.com";
		
		Response res=given().
			param("location","-33.8670522,151.1957362").
			param("radius","1502").
			param("type","restaurant").
			param("key","AIzaSyCBrME_E-clEAG8bxB3I4YVRU2O8sRLxS4").
		when().
			get("/maps/api/place/nearbysearch/json").
		then().
			assertThat().
				statusCode(200).
				and().
				contentType(ContentType.JSON).
				and().
				body("results[0].name",equalTo("QT Sydney")).extract().response();
		
		JsonPath json = RawDataConvertor.rawToJSON(res);
		int count = json.get("results.size()");
		System.out.println(count);
		for(int i=0; i<count; i++) {
			String name= json.get("results["+i+"].name");
			System.out.println("Results["+i+"]= "+name);
		}
	
	}

}
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=restaurant&keyword=cruise&key=YOUR_API_KEY