package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRequestTest 
{
	
		@Test
		public void deleteRecord()
		{
			int age=23;
			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification request = RestAssured.given();
			 
			 request.header("Content-Type", "application/json"); 	
			 
			 Response response = request.delete("/delete/"+ age); 
			 int statusCode = response.getStatusCode();
			 System.out.println(response.asString());
			 Assert.assertEquals(statusCode, 200);
			 
			 String jsonString =response.asString();
			 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
			 }
		}
		


