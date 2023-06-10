package com.selenium;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InconsistentPopup {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/");

        inconsistentPopup(driver);
    }

    public static void inconsistentPopup(WebDriver driver) {
        try {
            WebElement popUp = driver.findElement(By.xpath("//span[@class='sc-pVTFL gMNQJM']"));
            if (popUp.isDisplayed()) {
                popUp.click();
                System.out.println("The popup has been clicked!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Popup not found!");
        }
    }
}