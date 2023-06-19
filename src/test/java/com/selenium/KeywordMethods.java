package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class KeywordMethods {
    public static WebDriver driver;

    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void navigate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
    }

    public static void input_Username() {
        driver.findElement(By.name("email")).sendKeys("mercury");
    }

    public static void input_password() {
        driver.findElement(By.name("pass")).sendKeys("mercury");
    }

    public static void click_Login() throws InterruptedException {
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
    }

    public static void verify_login() {
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Facebook"), "Invalid credentials");
        System.out.println("Login Successful");
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
