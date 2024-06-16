package com.serenitybdd.stepdefinitions.UIStepDefs;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.serenitybdd.actions.UI.HomeSteps;
import com.serenitybdd.actions.UI.LoginSteps;
import com.serenitybdd.actions.UI.SignupSteps;
import com.serenitybdd.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Locale;

public class UiTestSteps {
    //@Managed
    //WebDriver driver;

    private static final Logger LOGGER = LoggerFactory.getLogger(UiTestSteps.class);
    LoginSteps login;
    HomeSteps home;
    HomePage homePage;
    SignupSteps signup;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage.open();
        try{home.clickConsent();}
        catch(Exception e){System.out.println("Consent button not found, continuing with the test.");
        }
    }

    @When("I click on the signup link")
    public void iClickOnTheSignupLink() {
        home.clickLogin();
    }

    @And("I enter email and name")
    public void iEnterEmailAndName() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(Locale.ENGLISH, new RandomService());
        String email = fakeValuesService.bothify("??????##@?????.com");
        String name = faker.name().name();
        login.enterName(name);
        login.enterSignupEmail(email);
    }

    @And("I click on the signup button")
    public void iClickOnTheSignupButton() {
        login.clickSignupButton();
    }

    @Then("I should be navigated to registration page")
    public void iShouldBeNavigatedToRegistrationPage() {
        String expectedTitle = "Enter Account Information";
        String actualTitle = signup.accountInformationPageShouldBeVisible();
        Assertions.assertThat(actualTitle).isEqualToIgnoringCase(expectedTitle);
    }
}
