package com.selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.edureka.co/");

        File sourceSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetSS = new File("C:\\Users\\saura\\Downloads\\Screenshot\\screenshot.jpg");
        Files.copy(sourceSS, targetSS);
        driver.close();
    }
}
