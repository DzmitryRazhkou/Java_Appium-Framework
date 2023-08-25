package org.example.pageObjects.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.pageObjects.android.basePage.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCatalogue extends AndroidActions {
    public ProductCatalogue(AndroidDriver driver) {
        super(driver);
    }

//        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();

    public static final By CART_TXT = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    public static final By ADD_TO_CART = AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']");
    public static final By CART_ICON = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");


    public void addProducts(int index) {
        driver.findElements(ADD_TO_CART).get(index).click();
        driver.findElements(ADD_TO_CART).get(index).click();
    }

    private WebElement getCartIcon() {
        return driver.findElement(CART_ICON);
    }

    private WebElement getCartTxt() {
        return driver.findElement(CART_TXT);
    }

    public void scrollToConverse(String brand) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + brand + "\"));"));
    }

    public CartPage doClickCartIcon() {
        getCartIcon().click();
        wait.until(ExpectedConditions.attributeContains(getCartTxt(), "text", "Cart"));
        return new CartPage(driver);
    }


}
