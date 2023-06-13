package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();

        dropdown_dynamic_autosuggest(driver);
    }

    public static void dropdown_dynamic_autosuggest(WebDriver driver) throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//textarea[@title='Search']"));
        dropdown.sendKeys("Quantum Physics");
        List<WebElement> dropdownOptionText = driver
                .findElements(By.xpath("//li[@data-view-type='1']/div/div[2]/div[1]//div[1]/span"));
        List<WebElement> dropdownOptionClick = driver.findElements(By.xpath("//li[@data-view-type='1']/div"));
        int count = dropdownOptionText.size();
        Thread.sleep(2000);

        for (int i = 0; i < count; i++) {
            String OptionValue = dropdownOptionText.get(i).getText();
            if (OptionValue.equals("Quantum Physics")) {
                dropdownOptionClick.get(i).click();
                System.out.println("Element " + i + "clicked.");
                break;
            } else {
                System.out.println("required value is not found in current iteration:" + i +
                        " hence retrying");
            }
        }
    }
}
