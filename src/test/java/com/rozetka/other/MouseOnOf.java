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
        Boolean bool;
        String str = "2 999 грн";
        String elementS = str.replaceAll("\\D", "");
        System.out.println(elementS);
        if (!elementS.equals("")) {
            if (Integer.parseInt(elementS) > 6000)
            System.out.println("The price "+ elementS + " higher than " + 6000);

        }
    }












    }

