package com.skamirullah.pages;

import com.skamirullah.enums.WaitStrategy;
import com.skamirullah.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.skamirullah.constants.FrameworkConstants.getExplicitWait;
import static com.skamirullah.driver.DriverManager.getDriver;

public class Basepage {

    protected void click(By locator, WaitStrategy waitStrategy){
        /**
         * We want to ensure user can only choose from list of predefined wait strategies
         */
        ExplicitWaitFactory
                .performExplicitWait(waitStrategy, locator)
                .click();
    }

    protected void enterText(By locator, String text, WaitStrategy waitStrategy){
        ExplicitWaitFactory
                .performExplicitWait(waitStrategy, locator)
                .sendKeys(text);
    }

    protected String getTitle(){
        return getDriver().getTitle();
    }
}
