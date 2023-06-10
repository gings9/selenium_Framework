package com.selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendarhandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/");
        driver.manage().window().maximize();
        InconsistentPopup.inconsistentPopup(driver);

        driver.findElement(By.xpath("//div[3][@class='sc-12foipm-33 djFwsb']/div")).click();
        System.out.println("Press 1 if you want to select Todays date");
        System.out.println("Press 2 if you want to select Other date");
        Scanner sc = new Scanner(System.in);
        int dateOption = sc.nextInt();

        switch (dateOption) {
            case 1:
                WebElement cDate = driver.findElement(By.xpath("//div[contains(@class,\'DayPicker-Day--today\')]"));
                cDate.click();
                System.out.println("Current date has been selected: " + cDate.getText());
                break;
            case 2:
                WebElement dates = driver.findElement(By.xpath(
                        "//div[text()=\"June 2023\"]/../../div[3]/div/div[contains(@class,\"DayPicker-Day\") and @aria-disabled=\"false\"]"));
                List<WebElement> datesText = dates
                        .findElements(By.xpath(
                                "//div[text()=\"June 2023\"]/../../div[3]/div/div[contains(@class,\"DayPicker-Day\") and @aria-disabled=\"false\"]/p"));
                int count = datesText.size();
                System.out.println("Enter an Expected date: ");
                int expDate = sc.nextInt();
                String EDate = String.valueOf(expDate);
                for (int i = 0; i < count; i++) {
                    String dateValue = datesText.get(i).getText();
                    if (dateValue.equals(EDate)) {
                        datesText.get(i).click();
                        System.out.println("Expected date clicked: " + dateValue);
                        driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();
                        break;
                    } else {
                        System.out.println("required value is not found in current iteration:" + i +
                                " hence retrying");
                    }
                }
                break;
            default:
                System.out.println("Please Select Correct Choice!");
                break;
        }
        sc.close();
        // driver.quit();
    }
}
