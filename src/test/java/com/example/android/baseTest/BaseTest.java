package com.example.android.baseTest;

import com.example.po.android.pages.FormPage;
import com.example.po.constants.Paths;
import com.example.po.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class BaseTest extends AppiumUtils {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;
    protected FormPage formPage;
    protected Properties properties;

    @BeforeMethod
    public void startAppium() {

        properties = AppiumUtils.launchProperties();

        String ipAddress = properties.getProperty("ipAddress");
        String port = properties.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        String appUrl = Paths.ANDROID_APP_URL;

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("AndroidDevice"));
        options.setAutomationName(properties.getProperty("AndroidAutomationName"));
        options.setUdid(properties.getProperty("AndroidUdid"));
        options.setApp(appUrl);

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Paths.PAGE_LOAD_TIMEOUT));

        formPage = new FormPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            takeScreenshot(driver, result.getMethod().getMethodName());
        }
        driver.quit();
        System.out.println(" =====> DRIVER Has Left APP!!! <===== ");
        service.stop();
        System.out.println(" =====> APPIUM SERVER Has Been Closed!!! <===== ");
    }
}
