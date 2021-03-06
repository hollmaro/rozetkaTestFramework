package com.rozetka;

import com.rozetka.libs.ParentTest;
import com.rozetka.pages.MainPage;
import com.rozetka.pages.PhonePage;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

/**
 * Created by roman on 3/3/17.
 */
public class TestPriceFilter extends ParentTest {
    MainPage mainPage;
    PhonePage phonePage;
    Logger log = Logger.getLogger(getClass());

    public TestPriceFilter(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("Testing price filter")
    @Description("Go to main page, click menu \"Smartphony, TV i electronika -> Smartpfony \" " +
            "then set price filter 0-6000uah and check if all prices are within the given range")
    @Test
    public void testOpeningMainPage() throws InterruptedException {
        mainPage = new MainPage(driver);
        phonePage = new PhonePage(driver);
        mainPage.openMainPage();

        Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        if (mainPage.isNotificationPanelIsPresent()) {
            mainPage.clickOtkazatsaOtUvedomlienij();
        }
        Assert.assertTrue(
                "Check steps",
                mainPage.clickMenuSmartphonesTvElectronic() &&
                        mainPage.clickMenuSmartPhones() &&
                        phonePage.typeMaxPrice("6000") &&
                        phonePage.clickPriceOkButton()
        );
        Assert.assertTrue("Check if price is lower than 6000 uah",
                phonePage.isMainPriceLowerThan(6000)
        );



    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
