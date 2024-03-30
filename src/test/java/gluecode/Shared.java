package gluecode;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Shared 
{
	public RequestSpecification request;
	public Response response;
	public Scenario scenario;
	
	@Before
	public void before(Scenario se)
	{
		scenario=se;
		SimpleDateFormat sf = new SimpleDateFormat("hh/mm/ss/dd/MMM/yyyy");
		Date dt = new Date();
		scenario.log("Hi, "+scenario.getName()+" is going to run now- "+sf.format(dt));
		
	}
	@After
	public void after(Scenario se)
	{
		scenario=se;
		scenario.log(scenario.getName()+" is "+scenario.getStatus().name());
	}

}
