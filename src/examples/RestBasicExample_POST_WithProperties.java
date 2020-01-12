package examples;
//it will have both example to add place and delete place from google map
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Payload;
import files.Resources;
public class RestBasicExample_POST_WithProperties {
	Properties prop = new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis =new FileInputStream("D:\\Learning\\Java\\Automation\\selenium\\basicTests\\src\\examples\\data.properties");
		prop.load(fis);
	}
	
	@Test
	public void RestTest1() {
		RestAssured.baseURI=prop.getProperty("host");
		
		Response res= given().
			queryParam("key", "qaclick123").
			body(Payload.getBodyValue()).
		when().
			post(Resources.getaddResource()).
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
			post(Resources.getdelResource()).
		then().assertThat().statusCode(200).and().body("status", equalTo("OK"));
		
		
		
		
		
		
		
		
		
			
				
	}

}
