package RestAssuredSamples;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetServices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  //firstGet();
		  //authenicationGet();
		  //validateGetResponse();
		  sendQueryParamGet();
	}
	
	public static void firstGet()
	{
		String URL ="Base URL";
		Response res = RestAssured.get(URL);
		System.out.println(res.getStatusCode()); //401
		System.out.println(res.getStatusLine()); //Http/1.1 401 Unauthorized
	}
	
	public static void authenicationGet()
	{
		String URL ="Base URL'";
		Response response = RestAssured
				.given()
				.auth()
				.basic("connor.horton","Welcome1")
				.get(URL);
		System.out.println(response.getStatusCode()); //200
		System.out.println(response.getStatusLine()); //Http/1.1 200 OK
		
		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);
		
		// Get all the headers. Return value is of type Headers.
		// Headers class implements Iterable interface, hence we
		// can apply an advance for loop to go through all Headers
		// as shown in the code below
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		

		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType =  response.header("Server");
		System.out.println("Server value: " + serverType);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
	}
	
	public static void validateGetResponse()
	{
		String URL ="Base URL'";
		Response response = RestAssured
				.given()
				.auth()
				.basic("connor.horton","Welcome1")
				.get(URL);
		System.out.println(response.getStatusCode()); //200
		System.out.println(response.getStatusLine()); //Http/1.1 200 OK
		
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());
		
		// First get the JsonPath object instance from the Response interface
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 // Then simply query the JsonPath object to get a String value of the node
		 // specified by JsonPath: City (Note: You should not put $. in the Java code)
		 String ProjectName = jsonPathEvaluator.get("items");
		 
		 // Let us print the city variable to see what we got
		 System.out.println("ProjectName received from Response " + ProjectName);
		
	}
	
	public static void sendQueryParamGet() {
		String URL ="Base URL";
		Response response = RestAssured
				.given()
				.auth()
				.basic("connor.horton","Welcome1")
				.queryParam("q","ProjectName", "MDName-3643-0000000000052")
				.get(URL);
		System.out.println(response.getStatusCode()); //200
		System.out.println(response.getStatusLine()); //Http/1.1 200 OK
		
	}
	
	  public static  void secondApproach() {
		// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification request = RestAssured.given();
			
			Response response = request.queryParam("q", "London,UK") 
					                   .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
					                   .get("/weather");
			
			String jsonString = response.asString();
			System.out.println(response.getStatusCode()); 
			
			
		}

}
