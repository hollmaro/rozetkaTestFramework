package com.rozetka;

import com.rozetka.libs.ParentTest;
import com.rozetka.pages.MainPage;
import com.rozetka.pages.PhonePage;
import com.rozetka.pages.SearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

/**
 * Created by roman on 4/3/17.
 */
public class TestSearch extends ParentTest {
    MainPage mainPage;
    SearchPage searchPage;
    public TestSearch(String browser) throws MalformedURLException {
        super(browser);
    }
    @Title("Testing price filter")
    @Description("Go to main page, click menu \"Smartphony, TV i electronika -> Smartpfony \" " +
            "then set price filter 0-6000uah and check if all prices are within the given range")
    @Test
    public void testOpeningMainPage() throws InterruptedException {
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        mainPage.openMainPage();

        String searchText = "Apple iPhone 7 Plus 256GB Black";

        Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        if (mainPage.isNotificationPanelIsPresent()) {
            mainPage.clickOtkazatsaOtUvedomlienij();
        }
        Assert.assertTrue("Check typing search words",
            mainPage.typeTextInSearch(searchText)&&
            mainPage.clickSearchButton()&&
            searchPage.isElementWithTextOnPage(searchText)
        );


    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
