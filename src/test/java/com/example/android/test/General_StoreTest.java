package com.example.android.test;

import com.example.android.baseTest.BaseTest;
import com.example.po.android.pages.CartPage;
import com.example.po.android.pages.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class General_StoreTest extends BaseTest {

/*
* //  @BeforeMethod  -----> BeforeClass, AfterClass
//    public void preSetup() {
//    formPage.setActivity();
//    }
* */

    @Test(dataProvider = "getData", groups = {"@Smoke"})
    public void generalStoreTest(String country, String name, String gender) {
        String brand = "Converse All Star";
        int productIndex = 0;

        formPage.doSelectCountry(country);
        formPage.setName(name);
        formPage.setGender(gender);

        ProductCatalogue productCatalogue = formPage.clickLetShop();
        productCatalogue.scrollToConverse(brand);
        productCatalogue.addProducts(productIndex);

        CartPage cartPage = productCatalogue.doClickCartIcon();
        Double prices = cartPage.getSummarizedPrice();
        Double totalPrice = cartPage.getTotalPrices();
        Assert.assertEquals(prices, totalPrice);

        cartPage.acceptTerms();
        cartPage.submitOrder();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Australia", "Gans", "Male"},
                {"Australia", "Lucy", "Female"},
                {"Australia", "Greg", "Male"}
        };
    }
}
