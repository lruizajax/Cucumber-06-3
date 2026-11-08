package com.shop.utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.shop.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.createDriver();
        DriverFactory.setDriver(driver);
        new HomePage(driver).goTo();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getDriver();
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot on failure", new ByteArrayInputStream(screenshot));
            }
        }
        DriverFactory.quitDriver();
    }
}
