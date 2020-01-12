package files;

public class Resources {
	
	public static String getaddResource()
	{
		String resadd="/maps/api/place/add/json";
		return resadd;
	}
	public static String getdelResource()
	{
		String resadd="/maps/api/place/delete/json";
		return resadd;
	}
	public static String getBookBody(String isbn, String aisle)
	{
		String resStr="{\r\n" + 
				"\"name\":\"Learn Appium Automation with Java-1-YogeshK\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"yogeshK\"\r\n" + 
				"}\r\n" + 
				"";
		return resStr;
		
	}
	public static String deletebook(String bookid)
	{
		String resStr="{\r\n" + 
				"\r\n" + 
				"\"ID\" : \""+bookid+"\"\r\n" + 
				"\r\n" + 
				"} \r\n" + 
				"";
		return resStr;
	}
	

}
