package com.rozetka.pages;

import com.rozetka.libs.WebElementOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.rozetka.libs.ConfigData.ui;

/**
 * Created by ROMAN on 06.03.2017.
 */
public class PhonePage {
    Logger log;
    WebElementOnPage webElementOnPage;
    WebDriver driver;

    /**
     * constructor
     * @param externalDriver
     */
    public PhonePage(WebDriver externalDriver){
        this.driver = externalDriver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);

    }
    public PhonePage(){
        this.driver = driver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);

    }

    /**
     * method typing max price
     * @param maxPrice
     * @return
     */
    @Step("Typing max price : {0}")
    public boolean typeMaxPrice(String maxPrice) {
        boolean tempElement =
                webElementOnPage.typeTextIntoInput(maxPrice, "PhonesPage.PriceMax.Input");
        log.info("Max price: " + maxPrice + "was typed: " + tempElement);
        return tempElement;
    }

    /**
     * method select 4" screen checkbox
     * @return
     */
    @Step("select 4\" screen checkbox")
    public boolean selectPhoneSize4() {
        boolean tempElement =
                webElementOnPage.clickLink("PhonesPage.ScreenSize.CheckBox.Do4");
        log.info("Was checked");
        return tempElement;
    }
}
