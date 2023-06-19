package com.selenium;

// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.idealized.Javascript;
//import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverListeners {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.in");

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        // EventCapture ecatpture = new EventCapture();

    }
}
