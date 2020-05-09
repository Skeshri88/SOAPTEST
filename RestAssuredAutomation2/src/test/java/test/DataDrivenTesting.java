package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting 
{
	
    @Test(dataProvider="updatedataprovider")
	public void postNewEmployees( String name,String job)
	{
		RestAssured.baseURL="https://reqres.in/api/users";
		RequestSpecification httpRequest= RestAssured.given();
		JSONOnject requestParameters= new JSONObject();
		requestParameters.put("name", "a");
		requestParameters.put("job", "jj");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParameters.toJSONString());
		
		Response response = 	httpREquest.request(Method.put,"/create");
		
		String responseBody= response.getBody().asString();
		Assert.assertEquals(responseBody.contains(name),true);
		Assert.assertEquals(responseBody.contains(age),true);
		
		int statuscode= response.getstatusCode();
		Assert.assertEquals(statuscode,200);
	}
	@DataProvider(name="updatedataprovider")
		String [][] getEmpData()
		{
			String 	updatedata[][]= { {"Shailesh","29"}, {"Keshri","45"} };
					return (updatedata);
		}
		
		
		
		
		
		
		
	

}
