package com.example.po.ios.pages;

import com.example.po.ios.basePage.IOSActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends IOSActions {
    public HomePage(IOSDriver driver) {
        super(driver);
    }

    public final static By ALERT_VIEWS = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Alert Views\"`]");


    private WebElement getAlertViews() {
        return driver.findElement(ALERT_VIEWS);
    }

    public AlertViewsPage selectAlertViews() {
        getAlertViews().click();
        return new AlertViewsPage(driver);
    }


}
