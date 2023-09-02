package com.example.po.utils;

import com.example.po.constants.Paths;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class AppiumUtils {
    protected AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/opt/homebrew/bin/appium"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withTimeout(Duration.ofSeconds(300))
                .withIPAddress(ipAddress)
                .usingPort(port).build();
        service.start();
        System.out.println(" =====> APPIUM SERVER Has Been Started!!! <===== ");
        return service;
    }

    public static Properties launchProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(Paths.CONFIG);
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return prop;
    }

    public Double getFormattedPrice(String price) {
        return Double.parseDouble(price.substring(1));
    }

    public void waitForElementToAppear(WebElement el, AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Paths.WEB_DRIVER_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.attributeContains((el), "text", "Cart"));
    }

    public static String takeScreenshot(AppiumDriver driver, String methodName) {
        String directory = Paths.SCREENSHOTS;
        new File(directory).mkdirs();

        String filePath = directory + getScreenshotFileName(methodName);
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return filePath;
    }

    private static String getScreenshotFileName(String methodName) {
        return methodName + "_" + new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date()) + ".png";
    }
}

