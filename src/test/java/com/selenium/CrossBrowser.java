package com.selenium;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowser {
    WebDriver driver;

    @BeforeTest
    // @Parameters("browser")
    public void setup(String browser) throws Exception {
        // check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            // create firefox instance
            System.setProperty("webdriver.gecko.driver", "firefox.exe");
            driver = new FirefoxDriver();
        }
        // check if parameter passed from TestNG is 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            // create chrome instance
            System.setProperty("webdriver.chrome.driver",
                    "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            // If no browser is passed throw exception
            throw new Exception("Browser is not correctly passed");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testParameterWithXML() throws InterruptedException {
        driver.get("https://www.edureka.co/");
        WebElement Login = driver.findElement(By.linkText("Log In"));
        Login.click();
        Thread.sleep(4000);

    }
}
