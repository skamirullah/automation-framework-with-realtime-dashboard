package com.skamirullah.tests;

import com.skamirullah.pages.OrangeHRMHomePage;
import com.skamirullah.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.skamirullah.driver.DriverManager.getDriver;

public final class OrangeHRMTests extends BaseTest{

    private OrangeHRMTests(){

    }

    @Test
    public void loginLogoutTest(){
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        String title = loginPage.enterUsername("Admin").enterPassword("admin123").clickOnLoginButton()
                 .clickOnUserProfileIcon().clickOnLogoutLink()
                 .getPageTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");

    }

}
