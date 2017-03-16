package com.rozetka.other;

import com.rozetka.libs.ConfigData;
import com.rozetka.pages.MainPage;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.rozetka.libs.ConfigData.getUiMappingValue;
import static com.rozetka.libs.ConfigData.getValueFromFile;

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


        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        driver.get("http://rozetka.com.ua/");

        actions.moveToElement(driver.findElement(By.xpath(".//*[@name='fat_menu_link' and contains(text(),'Смартфоны, ТВ и электроника')]"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath(".//*[contains(text(),' Смартфоны ')]"))).click().build().perform();

        /*mainPage.openMainPage();
        WebElement button = driver.findElement(ConfigData.ui("MainPage.Menu.Button"));
        WebElement smartphones = driver.findElement(ConfigData.ui("MainPage.Menu.SmartPhones.Link"));
        WebElement smartTvElectr = driver.findElement(ConfigData.ui("MainPage.Menu.SmartPhonesTvElectronic.Link"));

        Actions actions = new Actions(driver);*/



        //smartTvElectr.click();
        //actions.moveToElement(smartTvElectr).click().perform();
        //wait.until(ExpectedConditions.elementToBeClickable(smartphones));

        //actions.moveToElement(smartphones).click().build().perform();



        /*boolean te = b.isEnabled();
        System.out.println(te);
                    b.click();
        System.out.println(b);
        WebElement bb = driver.findElement(By.xpath("./[@href='http://rozetka.com.ua/mobile-phones/c80003/filter/preset=smartfon/']"));
        te = bb.isEnabled();
        System.out.println(te);
                    bb.click();*/
        //bb.click();
        //mainPage.clickMenuSmartphonesTvElectronic();
        // b = phones.equals(ui("MainPage.Menu.PhonesTvElectronic"));
        //System.out.println(b);
        //System.out.println(phones);
        System.out.println(getUiMappingValue("MainPage.Menu.SmartPhonesTvElectronic.Link"));
        System.out.println(ui("MainPage.Menu.SmartPhonesTvElectronic.Link"));

    }
    public static By ui(String key) {
        try {
            // Get WebElement's locator from UI mapping file and divide it to finding method and target
            String[] partsOfLocator = getValueFromFile(key, ConfigData.uiMappingFile).split("\"");
            String findMethod = partsOfLocator[0].substring(0, partsOfLocator[0].length() - 1);
            String target = partsOfLocator[1];
            System.out.println("target" + target);
            System.out.println("partsOfLocator" + partsOfLocator);

            // Return By class with appropriate method and target
            if (findMethod.equals("id")) {
                return By.id(target);
            } else {
                if (findMethod.equals("xpath")) {
                    return By.xpath(target);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}









