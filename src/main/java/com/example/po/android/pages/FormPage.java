package com.example.po.android.pages;

import com.example.po.android.basePage.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormPage extends AndroidActions {
    public FormPage(AndroidDriver driver) {
        super(driver);
    }

    public static final By SELECT_COUNTRY = AppiumBy.id("android:id/text1");
    public static final By COUNTRY = AppiumBy.xpath("//android.widget.TextView[@text='Australia']");
    public static final By YOUR_NAME_FIELD = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    public static final By MALE_RADIO_BTN = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    public static final By FEMALE_RADIO_BTN = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    public static final By LETS_SHOP_BTN = AppiumBy.className("android.widget.Button");

    /*
     *
     */

    private WebElement getSelectCountry() {
        return driver.findElement(SELECT_COUNTRY);
    }

    private WebElement getCountry() {
        return driver.findElement(COUNTRY);
    }

    private WebElement getYourNameField() {
        return driver.findElement(YOUR_NAME_FIELD);
    }

    private WebElement getMaleRadioBtn() {
        return driver.findElement(MALE_RADIO_BTN);
    }

    private WebElement getFemaleRadioBtn() {
        return driver.findElement(FEMALE_RADIO_BTN);
    }

    private WebElement getLetsShopBtn() {
        return driver.findElement(LETS_SHOP_BTN);
    }

    /*
     *
     */

    public void doSelectCountry(String country) {
        getSelectCountry().click();
        scrollToCountry(country);
        getCountry().click();
    }

    public void setName(String name) {
        getYourNameField().sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            getFemaleRadioBtn().click();
        } else {
            getMaleRadioBtn().click();
        }
    }

    public ProductCatalogue clickLetShop() {
        getLetsShopBtn().click();
        return new ProductCatalogue(driver);
    }

    public void setActivity() {
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
        driver.startActivity(activity);
    }
}
