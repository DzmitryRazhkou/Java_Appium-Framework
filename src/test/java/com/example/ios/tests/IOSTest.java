package com.example.ios.tests;

import com.example.ios.baseTest.IOSBaseTest;
import com.example.po.constants.Paths;
import com.example.po.ios.pages.AlertViewsPage;
import com.example.po.ios.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSTest extends IOSBaseTest {
    @Test
    public void iosTest() throws InterruptedException {
        String txt = "Royce Rolls";
        String msg = "A message should be a short, complete sentence.";

        homePage = new HomePage(driver);
        AlertViewsPage alertViewsPage = homePage.selectAlertViews();
        alertViewsPage.fillUpLabel(txt);
        String actMsg = alertViewsPage.getConfirmMsg();
        System.out.println(" =====> " + actMsg + " <===== ");
        Assert.assertEquals(actMsg, msg);
        alertViewsPage.clickConfirm();
    }
}
