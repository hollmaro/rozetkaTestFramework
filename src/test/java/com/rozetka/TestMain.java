package com.rozetka;

import com.rozetka.pages.MainPage;
import com.rozetka.pages.PhonePage;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

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
        /*Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        if (mainPage.isNotificationPanelIsPresent());
        mainPage.clickOtkazatsaOtUvedomlienij();*/

        mainPage.clickMenuSmartphonesTvElectronic();
        mainPage.clickMenuSmartPhones();

        phonePage.typeMaxPrice("6000");
        phonePage.selectPhoneSize4();



    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
