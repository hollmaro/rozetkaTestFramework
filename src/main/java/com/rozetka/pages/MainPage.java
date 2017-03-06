package com.rozetka.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.rozetka.libs.WebElementOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static com.rozetka.libs.ConfigData.getCfgValue;
import static com.rozetka.libs.ConfigData.getUiMappingValue;

/**
 * Created by roman on 3/2/17.
 */
public class MainPage {
    WebDriver driver;
    Logger log;
    WebElementOnPage webElementOnPage;
    String MAIN_PAGE_URL;
    String MAIN_PAGE_TITLE;

    /**
     * Constructor for MainPage
     * @param externalDriver
     */
    public MainPage(WebDriver externalDriver){
        this.driver = externalDriver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);
        MAIN_PAGE_URL = getCfgValue("MAIN_PAGE_URL");
        MAIN_PAGE_TITLE =
                "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие";
    }

    /**
     * method opens main page rozetka.com
     */
    @Step("Opening main page ROZETKA")
    public void openMainPage(){
        try {
        	webElementOnPage.openBrowserAndUrl(MAIN_PAGE_URL);
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
        log.info("Browser was closed from page " + MAIN_PAGE_URL);
    }

    /**
     * method close window, not browser instance
     */
    public void closeMainPage(){
        webElementOnPage.closePage();
        log.info("Main page was closed!");
    }

    /**
     * method click button for canceling notifications
     * @return boolean
     */
    public boolean clickOtkazatsaOtUvedomlienij() {
        boolean tempElement = webElementOnPage.clickButton(getUiMappingValue("MainPage.NotificationPanel.Cancel.Button"));
        log.info("Button for canceling notifications was clicked! ");
        return tempElement;
    }

    /**
     * method checks is notafication panel is on the page
     * @return boolean
     */
    public boolean isNotificationPanelIsPresent() {
        boolean tempElement =
            webElementOnPage.isElementOnPage(getUiMappingValue("MainPage.NotificationPanel"));
            log.info("Notification panel is present: " + tempElement);
            return tempElement;

    }

    /**
     * method clicked on MainPage.Menu.Phones.Link item
     * @return boolean
     */
    @Step("Clicking menu phones")
    public boolean clickMenuPhones() {
        boolean tempElement =
                webElementOnPage.clickLink(getUiMappingValue("MainPage.Menu.Phones.Link"));
        log.info("Was opened menu item: MainPage.Menu.Phones.Link: " + tempElement);
        return tempElement;
    }

    /**
     * method clicked on MainPage.Menu.Smartphones.Link item
     * @return boolean
     */
    @Step("Clicking menu smartphones")
    public boolean clickMenuSmartphones() {
        boolean tempElement =
                webElementOnPage.clickButton(getUiMappingValue("MainPage.Menu.Smartphones.Link"));
        log.info("Link Smartphones was clicked: " + tempElement);
        return tempElement;
    }

    /**
     * method move mouse on element
     */
    public boolean mouseOnElementSmartTvElectronic() {
        boolean tempElement =
                webElementOnPage.mouseOnElement(getUiMappingValue("MainPage.Menu.PhonesTvElectronic"));
        log.info("Mouse moved on element MainPage.Menu.PhonesTvElectronic: " + tempElement);
        return tempElement;
    }

    /**
     * get page title
     * @return String title
     */
    @Step("Is title corect")
    public String getMainTitle() {
        return MAIN_PAGE_TITLE;
    }

    public boolean typeTextInSearch(String textForSearch){
        try {
            webElementOnPage.typeTextIntoInput(textForSearch, "MainPage.Search.Input");
            log.info("Text " + textForSearch + "was typed in Search Input");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }
    }
}
