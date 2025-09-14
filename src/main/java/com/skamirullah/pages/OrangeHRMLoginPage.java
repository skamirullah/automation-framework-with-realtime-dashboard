package com.skamirullah.pages;

import com.skamirullah.enums.WaitStrategy;
import org.openqa.selenium.By;

import static com.skamirullah.driver.DriverManager.getDriver;

public final class OrangeHRMLoginPage extends Basepage {

    //All assertions should not be in page class, it should be in test class
    // All your page methods should needs to have some return type

    private final By usernameField = By.name("username");
    private final By passwordField = By.xpath("//input[@type='password' and @name='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username){
       enterText(usernameField, username, WaitStrategy.PRESENT);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        enterText(passwordField, password, WaitStrategy.PRESENT);
        return this;
    }

    public OrangeHRMHomePage clickOnLoginButton(){
        click(loginButton, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }
}
