package org.example.test;

import org.example.baseTest.BaseTest;
import org.example.pageObjects.android.pages.CartPage;
import org.example.pageObjects.android.pages.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class General_StoreTest extends BaseTest {
    @Test()
    public void generalStoreTest() throws InterruptedException {
        String country = "Australia";
        String name = "Gans";
        String gender = "Female";
        String brand = "Converse All Star";
        String terms = "Terms Of Conditions";
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
}
