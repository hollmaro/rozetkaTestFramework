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
 * Created by roman on 4/3/17.
 */
public class TestLoginValidData extends ParentTest{
    MainPage mainPage;

    public TestLoginValidData(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("Testing login form")
    @Description("Click \"Voidite v lichnyi cabinet\", enter invalid user credentials" +
            " and check if it will pass to enter to the cabinet")
    @Test
    public void TestLoginValidData() {
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
        Assert.assertTrue("Check typing text into inputs login/password",
                mainPage.typeTextIntoEmail("1") &&
                mainPage.typeTextIntoPassw("2")
        );
        mainPage.clickEnterButton();
        Assert.assertTrue("Check is input with ERROR style",
                mainPage.isEmailInputError()||
                mainPage.isPasswInputError()
        );
    }

    @After
    public void tearDown() {
        mainPage.closeBrowser();
    }
}
