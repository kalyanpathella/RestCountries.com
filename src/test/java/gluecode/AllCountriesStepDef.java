package gluecode;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import utility.PropertiesFileUtility;

public class AllCountriesStepDef 
{
	Shared sh;
	public AllCountriesStepDef(Shared sh)
	{
		this.sh=sh;
	}
	@Given("define HTTP request using path {string}")
	public void define_HTTP_request_using_path(String path)throws Exception
	{
		sh.request=RestAssured.given();
		sh.request.baseUri("https://restcountries.com/v3.1"+path);
		//sh.request.basePath(path);
		sh.request.header("Content-Type","application/json");
	}
	@When("submit request via HTTP GET method")
	public void submit_request_via_HTTP_GET_method()
	{
		sh.response=sh.request.get();
	}
	@Then("verify the status code is {int}")
	public void verify_the_status_code_is(int expstatus)
	{
		int actualStatus=sh.response.statusCode();
		if(expstatus==actualStatus)
		{
			Reporter.log("Status code test passed");
			sh.scenario.log("Statsu code test passed");
			Assert.assertTrue(true);
		}
		else 
		{
			Reporter.log("Status code test failed");
			sh.scenario.log("Statsu code test failed");
			Assert.assertTrue(false);
		}
	}
	@Then("vefiry the expected body and actual body both are same {string}")
	public void vefiry_the_expected_body_and_actual_body_both_are_same(String filepath)throws Exception
	{
		String jsontoString=new String(Files.readAllBytes(Paths.get(filepath)));
		JSONArray expectedArray=new JSONArray(jsontoString);
		JSONArray actualArray= new JSONArray(sh.response.then().extract().body().asString());
		JSONAssert.assertEquals("Get response:", expectedArray, actualArray,JSONCompareMode.LENIENT);
		
	}

}
