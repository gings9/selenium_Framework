package com.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");

        driver.manage().window().maximize();

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);
        WebElement clickWindow = driver.findElement(By.id("button1"));

        for (int i = 0; i < 3; i++) {
            clickWindow.click();
            Thread.sleep(3000);
        }

        Set<String> allwindows = driver.getWindowHandles();

        for (String handle : allwindows) {
            System.out.println("window handle: " + handle);

        }

    }
}
