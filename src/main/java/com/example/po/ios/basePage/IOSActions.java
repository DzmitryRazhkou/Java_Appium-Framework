package com.example.po.ios.basePage;

import com.example.po.utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions extends AppiumUtils {
    protected IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }

    public void scrollWebeElement(WebElement el) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement) el).getId());
        driver.executeScript("mobile:scroll", params);
    }

    public void longPress(WebElement el) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) el).getId());
        params.put("duration", 5);

        driver.executeScript("mobile:touchAndHold", params);
    }

}
