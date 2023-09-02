package com.example.ios.baseTest;

import com.example.po.constants.Paths;
import com.example.po.ios.pages.HomePage;
import com.example.po.utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {
    protected IOSDriver driver;
    protected AppiumDriverLocalService service;
    protected HomePage homePage;
    protected Properties properties;

    @BeforeMethod
    public void startAppium() {

        properties = AppiumUtils.launchProperties();

        String ipAddress = properties.getProperty("ipAddress");
        String port = properties.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        String appUrl = Paths.IOS_APP_URL;

        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName(properties.getProperty("IOSDevice"));
        xcuiTestOptions.setApp(appUrl);
        xcuiTestOptions.setPlatformVersion(properties.getProperty("IOSPlatformVersion"));
        xcuiTestOptions.setIncludeSafariInWebviews(true);
        xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(Paths.PAGE_LOAD_TIMEOUT));

        driver = new IOSDriver(service.getUrl(), xcuiTestOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Paths.PAGE_LOAD_TIMEOUT));

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            takeScreenshot(driver, result.getMethod().getMethodName());
        }
        if (driver != null) {
            driver.quit();
            System.out.println(" =====> DRIVER Has Left APP!!! <===== ");
            service.stop();
            System.out.println(" =====> APPIUM SERVER Has Been Closed!!! <===== ");
        }
    }
}
