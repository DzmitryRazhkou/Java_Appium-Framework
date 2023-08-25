package org.example.pageObjects.android.basePage;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void longGesture(WebElement $el) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) $el).getId(), "duration", 2000));
    }

    public void scrollThruAndroidUIAutomator() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }

    public void scrollToCountry(String country) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"));"));
    }

    public void dragAndDrop(WebElement $el, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) $el).getId(),
                "endX", x,
                "endY", y
        ));
    }

    public void scrollDown() {
        boolean canScrollMore = true;
        while (canScrollMore != false) {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }
    }

    public void swipeGesture(WebElement $el, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) $el).getId(),
                "direction", direction,
                "percent", 0.25
        ));
    }

    public Double getFormattedPrice(String price) {
        Double amountPrice = Double.parseDouble(price.substring(1));
        return amountPrice;
    }
}
