package com.serenitybdd.pages;

import net.serenitybdd.annotations.DefaultUrl;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;


@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {


    public static final By signupButton = By.xpath("//*[text()='Signup']");
    public static final By userNameField = By.xpath("//*[@name='name']");
    public static final By passwordField = By.xpath("//*[@name='password']");
    public static final By signupEmailField = By.xpath("(//*[@name='email'])[2]");
    public static final By signupPasswordField = By.xpath("//*[text()='Signup']");
    public static final By loginEmailField = By.xpath("(//*[@name='email'])[1]");
    public static final By loginButton = By.xpath("//*[text()='Login']");

}
