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

public class SelectableTest {

    private static final String URL = "https://demoqa.com/selectable";
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
    void clickTest(){

        assertEquals(0, driver.findElements(By.cssSelector("#verticalListContainer .active")).size());

        List <WebElement> items  = driver.findElements(By.cssSelector("#verticalListContainer li"));
        assertTrue(items.size() >= 1);

        items.get(0).click();

        assertEquals(1, driver.findElements(By.cssSelector("#verticalListContainer .active")).size());

        items  = driver.findElements(By.cssSelector("#verticalListContainer li"));
        items.get(0).click();


    }


}
