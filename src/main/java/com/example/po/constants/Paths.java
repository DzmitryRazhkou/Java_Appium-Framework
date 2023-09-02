package com.example.po.constants;

import java.io.File;

public class Paths {
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String CONFIG_MAIN = "src/main/java/com/example/po/";
    private static final String CONFIG_PATH = "config/config.properties";
    private static final String SCREENSHOT_PATH = "screenshots/";


    public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long WEB_DRIVER_WAIT_TIMEOUT = 10;
    public static final String IOS_APP_URL = "/Users/dzmitryrazhkou/Library/Developer/Xcode/DerivedData/UIKitCatalog-hhyzouxlnghfcdgwieeiwlfwsltn/Build/Products/Debug-iphonesimulator/UIKitCatalog.app";
    public static final String ANDROID_APP_URL = USER_DIRECTORY + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "General-Store.apk";
    public static final String CONFIG = CONFIG_MAIN + CONFIG_PATH;
    public static final String REPORTS = "reports/";
    public static final String SCREENSHOTS = USER_DIRECTORY + '/' + SCREENSHOT_PATH;
}
