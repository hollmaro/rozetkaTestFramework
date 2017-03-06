package com.rozetka.other;

import com.rozetka.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;

import static com.rozetka.libs.ConfigData.getUiMappingValue;
import static com.rozetka.libs.ConfigData.ui;

/**
 * Created by ROMAN on 05.03.2017.
 */
public class ForTraining {




    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
        System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");

        WebDriver driver = new FirefoxDriver();
        MainPage mainPage;
        mainPage = new MainPage(driver);
        String phones = "xpath(\".//*[@href='http://rozetka.com.ua/telefony-tv-i-ehlektronika/c4627949/' and @class='f-menu-l-i-link f-menu-l-i-link-arrow sprite-side novisited']\")";



        mainPage.openMainPage();
        WebElement b = driver.findElement(ui("MainPage.Search.Input"));
        mainPage.clickMenuPhones();

        /*boolean te = b.isEnabled();
        System.out.println(te);
                    b.click();
        System.out.println(b);
        WebElement bb = driver.findElement(By.xpath("./[@href='http://rozetka.com.ua/mobile-phones/c80003/filter/preset=smartfon/']"));
        te = bb.isEnabled();
        System.out.println(te);
                    bb.click();*/
        //bb.click();
        //mainPage.clickMenuSmartphones();
        // b = phones.equals(ui("MainPage.Menu.PhonesTvElectronic"));
        System.out.println(b);
        System.out.println(phones);
        System.out.println(getUiMappingValue("MainPage.Menu.PhonesTvElectronic"));
        System.out.println(ui("MainPage.Menu.PhonesTvElectronic"));
    }




}
