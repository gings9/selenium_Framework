package com.selenium.Cucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
    WebDriver driver;

    @Given("^Open the Chrome browser and launch the application$")
    public void Open_the_Chrome_browser_and_launch_the_application() throws Throwable {
        System.out.println("This Step open the Chrome browser and launch the application.");
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Course\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://twitter.com/i/flow/login");
    }

    @When("^Enter the Username and Password$")
    public void Enter_the_Username_and_Password() throws Throwable {
        System.out.println("This Step Enter the Username and Password on the Login page.");
        driver.findElement(By.xpath("//div[contains(@class,'css-1dbjc4n r-18u37iz r-16y2uox')]"))
                .sendKeys("8197816877");
    }

    @Then("^Reset the Credentials$")
    public void Reset_the_Credentials() throws Throwable {
        System.out.println("This Step clicks on the Reset Button.");
    }
}
