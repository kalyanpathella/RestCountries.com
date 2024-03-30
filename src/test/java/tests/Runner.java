package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\resources\\FeaturesFiles\\AllCountriesDetails.feature"},
                          glue = {"gluecode"},
                          monochrome = true,
                          plugin = {"pretty","html:target\\realtest.html"})
public class Runner extends AbstractTestNGCucumberTests
{

}
