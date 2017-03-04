package com.rozetka.libs;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.rozetka.libs.ConfigData.ui;


public class WebElementOnPage {

	WebDriver  driver;
	Logger log;
	WebDriverWait wait;

	
	public WebElementOnPage(WebDriver extDriver){
		this.driver = extDriver;
		log = Logger.getLogger(getClass());
		wait = new WebDriverWait(driver, 30);
	}
	
	/**
	 * Method opens Browser & URL 
	 * @param url
	 */
	public void openBrowserAndUrl(String url) {
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get(url);
			log.info("Browser and url" + url + "was opened!");
			
			
		} catch (Exception e) {
			log.error(e);
			Assert.assertTrue("Browser can't start", false);
			
		}
	}
	
	/**
	 * Method closes Browser
	 */
	public void closeBrowser() {
		try {
			driver.quit();
			log.info("Browser was closed!");
		} catch (Exception e) {
			log.error(e);
		}
		
	}
	/**
	 *All keys are from UIMapping.properties file 
	 */
	//If will not work - DELETE THIS METHOD
	public void closePage(){
		try {
			driver.get("");
		} catch (Exception e) {
		    log.error(e);// TODO: handle exception
		}
	}

	/**
	 *All keys are from UIMapping.properties file
	 */
	/**
	 * Method clear input and typing text in input
	 * @param text
	 * @param keyInputLocator
	 * @return result of typing
	 */
	public boolean typeTextIntoInput(String text, String keyInputLocator) {
		try {
			WebElement input;
			input = driver.findElement(ui(keyInputLocator));
			input.clear();
			input.sendKeys(text);
			log.info("Text " + text + " was typed in input!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method click link by keyLinkLocator
	 * @param keyLinckLocator
	 * @return
	 */
	public boolean clickLink(String keyLinckLocator) {
		try {
			WebElement link;
			link = driver.findElement(ui(keyLinckLocator));
			link.click();
			log.info("Link " + link + " was clicked!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method clicking on button by keyButtonLocator
	 * @param keyButtonLocator
	 * @return
	 */
	public boolean clickButton(String keyButtonLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyButtonLocator))));
			WebElement button = driver.findElement(ui(keyButtonLocator));
			button.click();
			log.info("Button " + button + " was clicked!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method clicking on radioButton by key from UIMaping
	 * @param keyRadioButtonLocator
	 * @return
	 */
	public boolean clickOnRadioButton(String keyRadioButtonLocator) {
		try {
			WebElement radioButton = driver.findElement(ui(keyRadioButtonLocator));
			radioButton.click();
			log.info("RadioButton " + radioButton + " was clicked!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method select text from DropDown
	 * @param keyLocatorMainDD
	 * @param itemText
	 * @return
	 */
	public boolean selectItemFromDDByText(String keyLocatorMainDD, String itemText) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyLocatorMainDD))));
			WebElement mainDD = driver.findElement(ui(keyLocatorMainDD));
			Select itemsFromDD = new Select(mainDD);
			itemsFromDD.selectByVisibleText(itemText);
			log.info("Item " + itemText + " was selected in DD!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method sets state in CheckBox
	 * @param keyCheckLocator
	 * @param stateFromTC (should be exactly "Check" or "UnChecked")
	 * @return
	 */
	public boolean setActionIncheckBox(String keyCheckLocator,String stateFromTC) {
		try {
			WebElement checkBox;
			checkBox = driver.findElement(ui(keyCheckLocator));
			if (checkBox.isSelected() && stateFromTC.equals("Check")){
				log.info("Is already checked");
			}
			else if (checkBox.isSelected() && stateFromTC.equals("UnChecked")){
				checkBox.click();
				log.info("Was unchecked");
			}
			else if (!checkBox.isSelected() && stateFromTC.equals("Check")){
				checkBox.click();
				log.info("Checked");
			}
			else if (!checkBox.isSelected() && stateFromTC.equals("UnChecked")){
				log.info("Is already unchecked");
			}
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	
	}
	/**
	 * Method checks presents of element on page
	 * @param keyElementLocator
	 * @return
	 */
	public boolean isElementOnPage(String keyElementLocator){
		try {
			WebElement tempElement;
			tempElement = driver.findElement(ui(keyElementLocator));
			if (tempElement.isEnabled() && tempElement.isDisplayed()){
				log.info("Element is present on page");
				return true;
			}
			else{
				log.info("Element is not Enable or not Displayed");
				return false;
			}
		} catch (Exception e) {
			log.info("Element not found");
			return false;
		}
		
	}
	/**
	 * Method cheks is element on page by xpath locator
	 * @param elementLocator
	 * @return
	 */
	public boolean isAnyElementOnPage(String elementLocator){
		try {
			WebElement tempElement;
			tempElement = driver.findElement(By.xpath(elementLocator));
			if (tempElement.isEnabled() && tempElement.isDisplayed()){
				log.info("Element is present on page");
				return true;
			}
			else{
				log.info("Element is not Enable or not Displayed");
				return false;
			}
		} catch (Exception e) {
			log.info("Element not found");
			return false;
		}
		
	}
	/**
	 * Method cheks is element has empty value by key from UIMapping.properties file
	 * @param keyElementLocator
	 * @return
	 */
	public boolean isElementHasEmptyValue(String keyElementLocator){
		try {
			WebElement tempElement = driver.findElement(ui(keyElementLocator));
			String valueConsist = tempElement.getAttribute("value");
			if(valueConsist.equals("")){
				log.info("Element is empty (cheked)!");
				return true;
			}
			else 
			log.info("Element is not empty!");
			return false;
					
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		
		
		
	}
	
}


	