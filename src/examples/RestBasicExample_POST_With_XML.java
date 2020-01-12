package examples;
//it will have both example to add place and delete place from google map
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import examples.RawDataConvertor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;
public class RestBasicExample_POST_With_XML {
	@Test
	public void RestTest1() throws IOException {
		RestAssured.baseURI="http://216.10.245.166";
		String xmlbody =RawDataConvertor.getString("D:\\Learning\\Java\\Automation\\selenium\\basicTests\\src\\files\\bodyxml.xml");
		
		Response res= given().
			queryParam("key", "qaclick123").
			body(xmlbody).
		when().
			post("/maps/api/place/add/xml"). // here we use XMl instead of JSON into resource 
		then().
		assertThat().statusCode(200).extract().response();
		XmlPath xmlData= RawDataConvertor.rawToXml(res);
		String place_id = xmlData.get("response.place_id");
		System.out.println("place_id" + place_id);
			
	}
	

}
