package com.rozetka.pages;

import com.rozetka.libs.WebElementOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by roman on 3/2/17.
 */
public class MainPage {
    WebDriver driver;
    Logger log;
    WebElementOnPage webElementOnPage;

    /**
     * Constructor for MainPage
     * @param externalDriver
     */
    public MainPage(WebDriver externalDriver){
        this.driver = externalDriver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);
    }

    /**
     * method opens main page rozetka.com
     */
    public void openMainPage(){
        try {
        	webElementOnPage.openBrowserAndUrl("http://rozetka.com.ua");
            log.info("Main page was opened!");
        } catch (Exception e) {
            log.error("Main page WASN'T opened!" + e);
        }
    }

    /**
     * method close browser from main page
     */
    public void closeBrowser(){
        webElementOnPage.closeBrowser();
        log.info("Browser was closed from page " + "http://rozetka.com.ua");
    }

    public void closeMainPage(){
        webElementOnPage.closePage();
        log.info("Main page was closed!");
    }
}
