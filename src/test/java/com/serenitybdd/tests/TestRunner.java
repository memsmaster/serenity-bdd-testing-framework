package com.serenitybdd.tests;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//CucumberWithSerenity
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        glue = {"com/serenitybdd/stepdefinitions"}
        //tags = "@API"
)
public class TestRunner {

}
