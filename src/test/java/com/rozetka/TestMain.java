package com.rozetka;

import com.rozetka.libs.ConfigData;
import com.rozetka.pages.MainPage;
import com.rozetka.pages.PhonePage;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

import static com.rozetka.libs.ConfigData.getUiMappingValue;
import static com.rozetka.libs.ConfigData.ui;

/**
 * Created by roman on 3/3/17.
 */
public class TestMain extends ParentTest {
    MainPage mainPage;
    PhonePage phonePage;
    Logger log = Logger.getLogger(getClass());

    public TestMain(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("First test!")
    @Description("Testing smart phone menu ")
    @Test
    public void testOpeningMainPage() throws InterruptedException {
        mainPage = new MainPage(driver);

        phonePage = new PhonePage(driver);

        mainPage.openMainPage();
        //mainPage.typeTextInSearch("123qwe123qwe");
        Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        if (mainPage.isNotificationPanelIsPresent());
            mainPage.clickOtkazatsaOtUvedomlienij();
        mainPage.clickMenuPhones();
        mainPage.clickMenuSmartphones();
        phonePage.typeMaxPrice("6000");
        phonePage.selectPhoneSize4();



    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
