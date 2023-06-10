package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.in");

        driver.manage().window().maximize();

        // Action class Object
        Actions act = new Actions(driver);

        // WebElement Object to Capture the Web Element
        // WebElement element =
        // driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
        WebElement searchElement = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        // 1. Hover over the Element
        // act.moveToElement(element).build().perform();

        // 2. Right Click over the Element
        // act.moveToElement(element).contextClick().build().perform();

        // 3. Double Click on the Element
        // act.moveToElement(element).doubleClick().build().perform();

        // 4. Press Shift key & send the Caps data to the Element
        act.moveToElement(searchElement).click().keyDown(Keys.SHIFT).sendKeys("iphone").build().perform();
    }
}
