package com.skamirullah.tests;

import com.skamirullah.driver.Driver;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static com.skamirullah.driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.*;


public final class HomePageTests extends BaseTest {

    private HomePageTests(){

    }

    /**
     * Validate whether the title is containing google search or Google Search
     * Verify whether title is not null and length is greater than 15 and less than 100
     * Check for the links in the page with text --> Sk Amir Ullah
     * Number of links is exactly 10 or 15
     */

    @Test
    public void test3(){
        getDriver().findElement(By.name("q")).sendKeys("Sk Amir Ullah", Keys.ENTER);
        String title = getDriver().getTitle();
        System.out.println("The title is: " + title);

        // Refactored way of assertion using AssertJ

        assertThat(title)
                        .as("Title is null").isNotNull()
                        .as("Title does not contain expected text").containsIgnoringCase("google search")
                        .as("Title length is not within the expected range")
                        .hasSizeBetween(15, 100);

        List<WebElement> elements = getDriver().findElements(By.xpath("//h3//span"));
        assertThat(elements)
                .as("Number of links is not as expected").hasSize(10)
                .extracting(WebElement::getText)
                .as("Sk Amir Ullah link text not found")
                .contains("Sk Amir Ullah");
        /**

         Old way of assertion

        Assert.assertTrue(title.contains("google search") || title.contains("Google Search"),
                "Title does not contain expected text");
        Assert.assertTrue(Objects.nonNull(title), "Title is null");
        Assert.assertTrue(title.length() > 15 && title.length() < 100,
                "Title length is not within the expected range");


        List<WebElement> elements = getDriver().findElements(By.xpath("//h3//span"));

        Assert.assertEquals(elements.size(), 10, "Number of links is not as expected");
        boolean isElementPresent = false;
        for(WebElement element: elements){
            if(element.getText().equals("Sk Amir Ullah")){
                isElementPresent = true;
                return;
            }
        }
        Assert.assertTrue(isElementPresent, "Sk Amir Ullah link text not found");

    }
         */

    }

}
