package com.selenium;

// import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "D:\\\\Selenium Course\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("null");
        driver.manage().window().maximize();

        // to handle Alert:
        // driver.findElement(By.id("")).click();
        // Alert alert = driver.switchTo().alert();
        // String alertMessage = driver.switchTo().alert().getText();
        // alert.accept();

        // to handle popup window
        // driver.findElement(By.id("popup")).click();
        // Robot robot = new Robot();
        // robot.moueMove(400, 5);
        // robot.mouePress(InputEvent.BUTTON1_DOWN_MASK);
        // robot.moueRelease(InputEvent.BUTTON1_DOWN_MASK);

    }
}
