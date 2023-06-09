package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NameAndIdLocator {

    public static void main(String[] args) throws InterruptedException {
        // set system properties with the location of WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");

        // create an object of chromedriver
        WebDriver driver = new ChromeDriver();

        // launch the application
        driver.get("https://www.amazon.in/");

        // to maximize the browser window
        driver.manage().window().maximize();

        // to get the list of drop down elements list
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        List<WebElement> dropdownList = dropdown.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));

        // get the size of the dropdown list
        int countOfDropDownList = dropdownList.size();

        // Method 1: by using click
        /*
         * dropdown.click();
         * Thread.sleep(1000);
         * for (int i = 1; i < countOfDropDownList; i++) {
         * String value = dropdownList.get(i).getText();
         * System.out.println(value); // print the value of the list
         * 
         * if (value.equals("Books")) { // we have to use .equals() to compare strings
         * dropdownList.get(i).click();
         * break;
         * } else {
         * System.out.println("required value is not found in current iteration:" + i +
         * " hence retrying");
         * }
         * }
         */

        // Method 2: by using select class
        Select selectObject = new Select(dropdown);
        // selectObject.selectByIndex(12);
        // selectObject.selectByValue("search-alias=stripbooks");
        // selectObject.selectByVisibleText("Books");

        for (int i = 1; i < countOfDropDownList; i++) {
            String value = dropdownList.get(i).getText();
            System.out.println(value); // print the value of the list

            if (value.equals("Books")) { // we have to use .equals() to compare strings
                selectObject.selectByVisibleText("Books");
                break;
            } else {
                System.out.println("required value is not found in current iteration:" + i +
                        " hence retrying");
            }
        }
        // Thread.sleep(2000);
        // driver.close();
        driver.quit();
    }
}