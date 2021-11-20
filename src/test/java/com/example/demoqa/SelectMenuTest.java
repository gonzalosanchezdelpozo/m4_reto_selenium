package com.example.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.time.Duration;
import java.util.List;


public class SelectMenuTest {

    private static final String URL = "https://demoqa.com/select-menu";
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {

        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get(URL);

    }


    @AfterEach
    void tearDown() {

        driver.quit();

    }

    @Test
    void todayDateTest(){

        WebElement multiselect = driver.findElement(By.id("cars"));
        js.executeScript("arguments[0].scrollIntoView();", multiselect);

        List <WebElement> options = driver.findElement(By.cssSelector("#cars option"));

        for(WebElement option: options){

            Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).click(option).perform();
        }



    }

}
