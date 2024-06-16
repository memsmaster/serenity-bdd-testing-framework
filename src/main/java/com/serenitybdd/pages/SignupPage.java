package com.serenitybdd.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com/signup")
public class SignupPage extends PageObject {
    public static final By accountInfoPage = By.xpath("//*[text()='Enter Account Information']");
}
