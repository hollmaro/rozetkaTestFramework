package com.rozetka.other;

import com.rozetka.libs.WebElementOnPage;
import com.rozetka.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ROMAN on 07.03.2017.
 */
public class MouseOnOf {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebElementOnPage webElementOnPage = new WebElementOnPage(driver);
        MainPage mainPage = new MainPage(driver);
        //System.out.println(ConfigData.ui("MainPage.NotificationPanel"));
        mainPage.openMainPage();
        //System.out.println(webElementOnPage.isElementOnPage("MainPage.NotificationPanel"));
        //System.out.println(mainPage.isNotificationPanelIsPresent());
        webElementOnPage.mouseOnElementAndClick("MainPage.Menu.Button");
        webElementOnPage.mouseOnElementAndClick("MainPage.Menu.SmartPhonesTvElectronic.Link");
        driver.findElement(By.xpath(".//a[@href='http://rozetka.com.ua/mobile-phones/c80003/filter/']")).click();












    }
}
