package com.rozetka.other;

import com.rozetka.libs.ConfigData;
import com.rozetka.libs.WebElementOnPage;
import com.rozetka.pages.MainPage;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.rozetka.libs.ConfigData.getUiMappingValue;
import static com.rozetka.libs.ConfigData.getValueFromFile;
import static com.rozetka.libs.ConfigData.ui;

/**
 * Created by ROMAN on 05.03.2017.
 */
public class ForTraining {




    public static void main(String[] args) throws InterruptedException {
        //-------------Configure drivers for WIN-----------------------------------
        /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
        System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");*/

        WebDriver driver = new ChromeDriver();
        MainPage mainPage;
        mainPage = new MainPage(driver);
        WebElementOnPage webElementOnPage= new WebElementOnPage(driver);


        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);




        mainPage.openMainPage();
        mainPage.typeTextInSearch("sony");
        mainPage.clickSearchButton();
        String st = String.format(".//*[contains(text(), '%1$s')]", "sony");
        System.out.println(driver.findElement(By.xpath(st)).getText());

    }

}









