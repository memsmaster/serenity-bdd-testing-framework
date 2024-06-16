package com.serenitybdd.actions.UI;
import com.serenitybdd.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import java.time.Duration;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginSteps extends UIInteractionSteps {


	@Step("User enters email address")
	public void enterEmail(String email) {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(LoginPage.loginEmailField));
		find(LoginPage.loginEmailField).sendKeys(email);
	}

	@Step("User enters password")
	public void enterPassword(String password) {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(LoginPage.passwordField));
		find(LoginPage.passwordField).sendKeys(password);
	}
	@Step("User clicks login button")
	public void clickLoginButton() {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(LoginPage.loginButton));
		find(LoginPage.loginButton).click();
	}
	@Step("User enters signup email address")
	public void enterSignupEmail(String email) {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(LoginPage.signupEmailField));
		find(LoginPage.signupEmailField).sendKeys(email);
	}

	@Step("User enters name")
	public void enterName(String name) {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(LoginPage.userNameField));
		find(LoginPage.userNameField).sendKeys(name);
	}
	@Step("User clicks login button")
	public void clickSignupButton() {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(LoginPage.signupButton));
		find(LoginPage.signupButton).click();
	}
}