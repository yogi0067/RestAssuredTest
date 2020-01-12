package examples;

import org.testng.annotations.Test;

import files.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

public class LibraryAPI_withJsonfile {

	@Test(priority = 1)
	public void bookAdd() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res= given().
		header("Content-Type","application/json").
			body(RawDataConvertor.getString("D:\\Learning\\Java\\Automation\\selenium\\basicTests\\src\\files\\bodyjson.json")).
		when().
			post("Library/Addbook.php").
		then().assertThat().body("Msg", equalTo("successfully added")).
		extract().response();
		System.out.println(res.asString());
		
	}
	@Test(priority = 2)
	public void bookGetById()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=
		given().
			param("ID","test0067").
		when().
			get("/Library/GetBook.php").
		then().
			assertThat().statusCode(200).
		extract().response();
		
		System.out.println(res.asString());
		
	}
	@Test(priority = 3)
	public void bookGetByAuthor()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=
		given().
			param("AuthorName","yogeshK").
		when().
			get("/Library/GetBook.php").
		then().
			assertThat().statusCode(200).
		extract().response();
		
		System.out.println(res.asString());
		
	}
	@Test(priority = 4)
	public void bookDelete()
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
			body(Resources.deletebook("test0067")).
		when().
			post("/Library/DeleteBook.php").
		then().
			assertThat().
				body("msg", equalTo("book is successfully deleted")).
		extract().response();
		
		System.out.println(res.asString());	
		
	}
	
	
}
