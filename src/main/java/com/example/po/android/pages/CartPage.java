package com.example.po.android.pages;

import com.example.po.android.basePage.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends AndroidActions {

    public static final By PRICES = AppiumBy.id("com.androidsample.generalstore:id/productPrice");
    public static final By TOTAL_PRICE = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
    public static final By TERMS_BTN = AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    public static final By ACCEPT_BTN = AppiumBy.id("android:id/button1");
    public static final By CHECK_BOX = AppiumBy.className("android.widget.CheckBox");
    public static final By PROCEED_BTN = AppiumBy.id("com.androidsample.generalstore:id/btnProceed");

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    private List<WebElement> getPrice() {
        return driver.findElements(PRICES);
    }

    private String totalPrice() {
        return driver.findElement(TOTAL_PRICE).getText();
    }

    private WebElement getTerms() {
        return driver.findElement(TERMS_BTN);
    }

    private WebElement getAcceptBtn() {
        return driver.findElement(ACCEPT_BTN);
    }

    private WebElement getCheckBox() {
        return driver.findElement(CHECK_BOX);
    }

    private WebElement getProceedBtn() {
        return driver.findElement(PROCEED_BTN);
    }

    public double getSummarizedPrice() {
        double sum = 0;
        int amountPrices = getPrice().size();
        for (int i = 0; i < amountPrices; i++) {
            String amountString = getPrice().get(i).getText();
            Double prices = getFormattedPrice(amountString);
            sum += prices;
        }
        System.out.println(" =====> Summarized Price From Two Products is: " + sum + " <===== ");
        return sum;
    }

    public double getTotalPrices() {
        double totalPrice = getFormattedPrice(totalPrice());
        System.out.println(" =====> Total Price is: " + totalPrice + " <===== ");
        return totalPrice;
    }

    public void acceptTerms() {
        longGesture(getTerms());
        getAcceptBtn().click();
    }

    public void submitOrder() {
        getCheckBox().click();
        getProceedBtn().click();
    }

}
