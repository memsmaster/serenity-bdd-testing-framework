package com.serenitybdd.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com")
public class HomePage extends PageObject {

    public static final By linkProducts = By.xpath("//a[@href='/products']");

    public static final By linkLogin = By.xpath("//a[@href='/login']");

    public static final By linkCart = By.cssSelector("html > body > header > div > div > div > div:nth-of-type(2) > div > ul > li:nth-of-type(3) > a");

    public static final By cookieConsent = By.xpath("(//*[text()='Consent'])[1]");





}
