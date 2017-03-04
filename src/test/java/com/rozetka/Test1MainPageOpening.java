package com.rozetka;

import com.rozetka.pages.MainPage;
import org.junit.After;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by roman on 3/3/17.
 */
public class Test1MainPageOpening extends ParentTest {
    MainPage mainPage;

    public Test1MainPageOpening(String browser) throws MalformedURLException {
        super(browser);
    }

    @Test
    public void testOpeningMainPage(){
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
