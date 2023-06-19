package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.in");

        Thread.sleep(2000);
        try {
            driver.findElement(By.id("Fake")).click();

        } catch (Exception e) {
            System.out.println("No such element found");
            System.out.println("I am inside the Catch Block");
        } finally {
            System.out.println("I am inside the finally Block");

        }
    }
}
