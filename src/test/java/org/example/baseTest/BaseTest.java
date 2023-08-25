package org.example.baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.example.pageObjects.android.pages.FormPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;
    protected FormPage formPage;

    @BeforeMethod
    public void startAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder()

                /*

//        Map<String, String> env = new HashMap<>(System.getenv());
//        env.put("ANDROID_HOME", "/Users/dzmitryrazhkou/Library/Android/sdk");
//        env.put("JAVA_HOME", "/Users/dzmitryrazhkou/Library/Java/JavaVirtualMachines/openjdk-18.0.2.1/Contents/Home");

                 * //            .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                                 .withEnvironment(env)
                 * */

                .withAppiumJS(new File("/opt/homebrew/bin/appium"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withTimeout(Duration.ofSeconds(300))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();
        System.out.println(" =====> APPIUM SERVER Has Been Started!!! <===== ");

        /*
        //        String appUrl = "/Users/dzmitryrazhkou/Documents/Preparation/Java_Appium-Framework/src/test/java/resources/General-Store.apk";
        * */

        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "General-Store.apk";


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("GansPhone_Pixel");
        options.setAutomationName("UIAutomator2");
        options.setUdid("emulator-5554");
        options.setApp(appUrl);

        /*
         * //        options.setChromedriverExecutable("/Users/dzmitryrazhkou/Documents/Preparation/Appium_Start/src/main/java/org/example/utils/chromedriver");
         * */

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        formPage = new FormPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println(" =====> DRIVER Has Left APP!!! <===== ");
        service.stop();
        System.out.println(" =====> APPIUM SERVER Has Been Closed!!! <===== ");
    }
}
