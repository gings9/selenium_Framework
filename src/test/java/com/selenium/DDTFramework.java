package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTFramework {
    ChromeDriver driver;

    @Test(dataProvider = "testdata")
    public void DemoProject(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.getTitle().contains("Facebook"), "Invalid credentials");
        System.out.println("Login Successful");
    }

    @AfterMethod
    void ProgramTermination() {
        driver.quit();
    }

    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed() {
        ReadFromExcelToDDT config = new ReadFromExcelToDDT("C:\\Users\\saura\\Downloads\\Login Credentials.xlsx");

        int rows = config.getRowCount(0);

        Object[][] credentials = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            credentials[i][0] = config.getData(0, i, 0);
            credentials[i][1] = config.getData(0, i, 1);
        }
        return credentials;
    }
}
