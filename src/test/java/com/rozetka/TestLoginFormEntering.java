package com.rozetka;

import com.rozetka.libs.ParentTest;
import com.rozetka.pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

/**
 * Created by roman on 3/10/17.
 */
public class TestLoginFormEntering extends ParentTest {
    MainPage mainPage;

    public TestLoginFormEntering(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("Testing login form")
    @Description("Click \"Voidite v lichnyi cabinet\" and check if login form is visible and enable")
    @Test
    public void TestLogin() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        if (mainPage.isNotificationPanelIsPresent()) {
            mainPage.clickOtkazatsaOtUvedomlienij();
        }
        Assert.assertTrue("Check is login form present",
                mainPage.clickEnterInCabinet()&&
                mainPage.isLoginFormPresent()
        );
    }

    @After
    public void tearDown() {
        mainPage.closeBrowser();
    }
}
