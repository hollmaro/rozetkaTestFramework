package com.rozetka.pages;

import com.rozetka.libs.WebElementOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

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
    /**
     * method typing max price
     * @param maxPrice
     * @return
     */
    @Step("Typing max price : {0}")
    public boolean typeMaxPrice(String maxPrice) {
        boolean tempElement =
                webElementOnPage.typeTextIntoInput(maxPrice, "PhonesPage.PriceMax.Input");
        log.info("Max price: " + maxPrice + " was typed: " + tempElement);
        return tempElement;
    }

    /**
     * method select 4" screen checkbox
     * @return
     */
    @Step("Click button \"OK\" for price filter")
    public boolean clickPriceOkButton() {
        boolean tempElement =
                webElementOnPage.clickLink("PhonesPage.PriceFilter.Submit.Button");
        log.info("Button \"OK\" for price filter was clicked: " + tempElement);
        return tempElement;
    }

    /**
     * method checks if price is lower than <PRICE>
     * @param price
     * @return
     */
    @Step("Checks if price is lower than: {0}")
    public boolean isMainPriceLowerThan(int price){
        boolean bool = true;
        String elementS;
        List<WebElement> list = webElementOnPage.collectionOfElements("PhonesPage.ActualPrices.List");
        for(WebElement element: list) {
            elementS = element.getText().replaceAll("\\D", "");
            if (!elementS.equals("")) {
                if (Integer.parseInt(elementS) > price)
                    bool = false;
                    break;
            }
        }
        log.info("All prices are lower than " + price + " : " + bool);
        return bool;

    }
}
