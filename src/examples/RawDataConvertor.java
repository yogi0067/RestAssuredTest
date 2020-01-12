package examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class RawDataConvertor {

	public static XmlPath rawToXml(Response res) {
		String resStr = res.asString();
		return new XmlPath(resStr);
	}
	public static JsonPath rawToJSON(Response res) {
		String resStr = res.asString();
		return new JsonPath(resStr);
	}
	public static String getString(String path) throws IOException 
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
}
