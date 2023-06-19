package com.selenium.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/Cucumber/Features.feature", glue = { " Steps" })
public class TestRunner extends AbstractTestNGCucumberTests {
    public static void main(String[] args) {

    }
}
