package gluecode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 
{
	public static void main(String[] args) 
	{
		RequestSpecification request=RestAssured.given();
		request.baseUri("https://restcountries.com/v3.1/all");
		Response response=request.get();
		int status=response.statusCode();
		System.out.println(status);
		String cont=response.contentType();
		System.out.println(cont);
		response.then().log().all();
		
	}

}
