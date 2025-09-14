package com.skamirullah.pages;

import com.skamirullah.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends Basepage {

    private final By userProfileIcon = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By logoutLink = By.xpath("//a[text()='Logout']");


    public OrangeHRMHomePage clickOnUserProfileIcon(){
        click(userProfileIcon, WaitStrategy.PRESENT);
        return this;
    }

    public OrangeHRMLoginPage clickOnLogoutLink(){
        click(logoutLink, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();
    }
}
