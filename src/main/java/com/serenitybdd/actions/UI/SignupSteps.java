package com.serenitybdd.actions.UI;


import com.serenitybdd.pages.SignupPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SignupSteps extends UIInteractionSteps {

    @Step("Account Information page should be visible")
    public String accountInformationPageShouldBeVisible() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(SignupPage.accountInfoPage));
        return find(SignupPage.accountInfoPage).getText();
    }
}
