package com.skamirullah.driver;

import com.skamirullah.enums.ConfigProperties;
import com.skamirullah.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static com.skamirullah.driver.DriverManager.*;

public final class Driver {

    private Driver(){
    }

    public static void initDriver() throws Exception {
        if(Objects.isNull(getDriver())) {
            WebDriver driver = new ChromeDriver();
            setDriver(driver);
            getDriver().manage().window().maximize();
            getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload(); //As suggested by SonarQube
        }
    }
}
