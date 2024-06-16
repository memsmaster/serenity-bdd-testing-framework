package com.serenitybdd.actions.UI;

import com.serenitybdd.pages.HomePage;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomeSteps extends UIInteractionSteps {

	@Step("User clicks products link")
	public void clickProductsLink() {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(HomePage.linkProducts));
		find(HomePage.linkProducts).click();
	}

	@Step("User clicks login link")
	public void clickLogin() {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(HomePage.linkLogin));
		find(HomePage.linkLogin).click();
	}
	@Step("User clicks cookie consent button")
	public void clickConsent() {
		withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(HomePage.cookieConsent));
		find(HomePage.cookieConsent).click();
	}
}