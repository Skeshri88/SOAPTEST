package test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequestTest
{
	@Test
	void getreqresdetails()
	{
		//specify baseurl
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RequestSpecification httprequest= RestAssured.given();
		
		Response Object
		Response response = httprequest.request(Method.GET,"first_name");
		String responseBody=response.getBody().asString();
		System.out.println("Response body is:"+ responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is "+ statusCode);
		Assert.assertEquals(statusCode,200);
		
		status line verification
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine,200);
		
		
		
	}
}

