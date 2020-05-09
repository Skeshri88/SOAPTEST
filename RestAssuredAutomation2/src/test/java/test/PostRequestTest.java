package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequestTest
{

	@Test
	void PsotRequestValidation()
	{
		//specify baseurl
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest= RestAssured.given();
		
		Response Object
		JSONObject requestParameters= new JSONObject();
		requestParameters.compute("name:","morpheus");
		requestParameters.compute("job:","associate");
		
		httprequest.header("content-Type","application/json");
		httprequest.body("requestParams.toJSONString()");
		
		
		
			
		Response response=  httprequest.request(Method.POST,"/register");
		
		
		String responseBody=response.getBody().asString();
		System.out.println("Response body is:"+ responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is "+ statusCode);
		Assert.assertEquals(statusCode,201);
		
		String successCode= response.jsonPath().get("successCode");
		
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine,200);
		
		
		
	}
}
