package RestAssuredSamples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostPutDeleteServices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readFromJsonandPostWithPayload2();
		//readFromJsonandPatchWithPayload();
	 	deleteRequest();
	}
	
	public static void firstGet()
	{
		String URL ="BASEURL";
		Response res = RestAssured.post(URL);
		System.out.println(res.getStatusCode()); //401
		System.out.println(res.getStatusLine()); //Http/1.1 401 Unauthorized
		 
	}
	
	public static void readFromJsonandPostWithPayload()
	{
		JSONParser jsonParser = new JSONParser();
        
        try 
        {
        	FileReader reader = new FileReader("sample.json");
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONObject obj2 = (JSONObject) obj.get("Test1");
            
            System.out.println(obj.get("Test1"));
             
            //Iterate over employee array
            String URL ="BaseURL";
           // RequestSpecification request = RestAssured.given();
           // request.body(obj.toJSONString());
            
    		Response res = RestAssured.given()
    				.body(obj2.toJSONString())
    				.header("Content-Type","application/json")
    				.auth()
    				.basic("connor.horton","Welcome1")
    				.post(URL);
    		
    		System.out.println(res.getStatusCode()); //201
    		System.out.println(res.getStatusLine()); //Http/1.1 201 Created
    		System.out.println(res.getBody().asString()); //returns the error message in case of 400 Bad Request
    		
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
	}
	
	public static void readFromJsonandPostWithPayload2()
	{
		
		JSONParser jsonParser = new JSONParser();
        try 
        {
        	FileReader reader = new FileReader("sample.json");
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONObject obj2 = (JSONObject) obj.get("Test2");
            
            System.out.println(obj.get("Test2"));
             
            //Iterate over employee array
            String URL ="BASEURL";
          
            
    		Response res = RestAssured.given()
    				.body(obj2.toJSONString())
    				.header("Content-Type","application/json")
    				.auth()
    				.basic("connor.horton","Welcome1")
    				.post(URL);
    		System.out.println(res.getStatusCode()); //201
    		System.out.println(res.getStatusLine()); //Http/1.1 201 Created
    		System.out.println(res.getBody().asString());
    		
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void readFromJsonandPatchWithPayload()
	{
		
		JSONParser jsonParser = new JSONParser();
        try 
        {
        	FileReader reader = new FileReader("sample.json");
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONObject obj2 = (JSONObject) obj.get("Test3");
            
            System.out.println(obj.get("Test3"));
             
            //Iterate over employee array
            String URL ="URL";
          
            
    		Response res = RestAssured.given()
    				.body(obj2.toJSONString())
    				.header("Content-Type","application/json")
    				.auth()
    				.basic("connor.horton","Welcome1")
    				.patch(URL);
    		System.out.println(res.getStatusCode()); //200
    		System.out.println(res.getStatusLine()); //Http/1.1 200 OK
    		System.out.println(res.getBody().asString());
    		
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void deleteRequest()
	{
		
            String URL ="URL";
          
            
    		Response res = RestAssured.given()
    				.header("Content-Type","application/json")
    				.auth()
    				.basic("connor.horton","Welcome1")
    				.delete(URL);
    		System.out.println(res.getStatusCode()); //204
    		System.out.println(res.getStatusLine()); //Http/1.1 204 No Content
    		System.out.println(res.getBody().asString());
    		
       
	}
}
