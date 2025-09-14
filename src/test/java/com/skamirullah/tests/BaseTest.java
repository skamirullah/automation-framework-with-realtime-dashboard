package com.skamirullah.tests;

import com.skamirullah.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest {

    protected BaseTest(){

    }

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
