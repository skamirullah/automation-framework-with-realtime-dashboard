package com.skamirullah.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.skamirullah.driver.DriverManager.getDriver;

public final class LoginPageTests extends BaseTest{

    //Rules
    //Never Hardcode the values
    //Keep Right thing at right place


    public static String appUrl = "https://google.com";

    private LoginPageTests(){

    }

//    @Test
//    public void test1(){
//        getDriver().findElement(By.name("q")).sendKeys("Sk Amir Ullah", Keys.ENTER);
//    }

//    @Test
//    public void test2(){
//        getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
//    }
}
