package com.skamirullah.factory;

import com.skamirullah.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.skamirullah.constants.FrameworkConstants.getExplicitWait;
import static com.skamirullah.driver.DriverManager.getDriver;

public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator) {
        WebElement element = null;
        if(waitStrategy == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(getDriver(), Duration.ofSeconds(getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if(waitStrategy == WaitStrategy.VISIBILE){
            element = new WebDriverWait(getDriver(), Duration.ofSeconds(getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if(waitStrategy == WaitStrategy.PRESENT){
            element = new WebDriverWait(getDriver(), Duration.ofSeconds(getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.NONE) {
            element = getDriver().findElement(locator);
        } else {
            throw new IllegalStateException("Invalid wait strategy: " + waitStrategy);
        }
        return element;
    }
}
