package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\\\Selenium Course\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com//droppable");
        driver.manage().window().maximize();

        // Switch to Frame
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(frameElement);

        // Come back from Frame
        /// driver.switchTo().parentFrame();

        // Drag and drop
        Actions mouseAction = new Actions(driver);

        WebElement sourceElement = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement destinationElement = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));

        mouseAction.dragAndDrop(sourceElement, destinationElement).build().perform();

        Thread.sleep(2000);

        driver.close();
    }
}
