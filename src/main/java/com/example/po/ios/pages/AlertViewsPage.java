package com.example.po.ios.pages;

import com.example.po.ios.basePage.IOSActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertViewsPage extends IOSActions {
    public AlertViewsPage(IOSDriver driver) {
        super(driver);
    }

    public final static By TEXT_ENTRY = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]");
    public final static By CONFIRM_POPUP = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'");
    public final static By INPUT = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]");
    public final static By OK = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"OK\"`]");
    public final static By CONFIRM_CANCEL = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'");
    public final static By MSG = AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'");

    public final static By CONFIRM = AppiumBy.iOSNsPredicateString("label == \"Confirm\"");

    /*
     **
     **
     **
     */

    private WebElement getTextEntry() {
        return driver.findElement(TEXT_ENTRY);
    }

    private WebElement getConfirmPopUp() {
        return driver.findElement(CONFIRM_POPUP);
    }

    private WebElement getInput() {
        return driver.findElement(INPUT);
    }

    private WebElement getOK() {
        return driver.findElement(OK);
    }

    private WebElement getConfirmCancel() {
        return driver.findElement(CONFIRM_CANCEL);
    }

    private WebElement getMsg() {
        return driver.findElement(MSG);
    }

    private WebElement getConfirmBtn() {
        return driver.findElement(CONFIRM);
    }

    /*
     **
     **
     **
     */

    public void fillUpLabel(String txt) {
        getTextEntry().click();
        getInput().sendKeys(txt);
        getOK().click();
    }

    public String getConfirmMsg() {
        getConfirmCancel().click();
        return getMsg().getText();
    }

    public void clickConfirm() {
        getConfirmBtn().click();
    }

}
