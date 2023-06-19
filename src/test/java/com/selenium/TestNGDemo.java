package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {
    String driverpath = "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe";
    public String baseURL = "https://www.edureka.co/";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        System.out.println("Launching Chrome Browser");
        System.setProperty("webdriver,chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyHomepageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterTest
    public void browserTerminated() {
        driver.close();
    }
}
