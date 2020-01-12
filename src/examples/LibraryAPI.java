package examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LibraryAPI {

	@Test(dataProvider = "data", priority = 1)
	public void bookAdd(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res= given().
		header("Content-Type","application/json").
			body(Resources.getBookBody(isbn, aisle)).
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
			param("ID","bcd0067").
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
	@Test(dataProvider = "data",priority = 4)
	public void bookDelete(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
			body(Resources.deletebook(isbn+aisle)).
		when().
			post("/Library/DeleteBook.php").
		then().
			assertThat().
				body("msg", equalTo("book is successfully deleted")).
		extract().response();
		
		System.out.println(res.asString());	
		
	}
	@DataProvider(name="data")
	public Object[][] getData()
	{
		return new Object[][] {{"book","1"},{"book","2"},{"book","3"} };
		
	}
	
}
