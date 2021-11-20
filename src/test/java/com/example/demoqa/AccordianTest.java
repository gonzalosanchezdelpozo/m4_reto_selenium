package com.example.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.time.Duration;
import java.util.List;


public class AccordianTest {

    private static final String URL = "https://demoqa.com/accordian";
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
    void section1Test(){

        assertEquals(1, driver.findElements(By.cssSelector("#accordianContainer .collapse.show")).size());

        WebElement heading1 = driver.findElement(By.id("section1Heading"));
        heading1.click();

        assertEquals(0, driver.findElements(By.cssSelector("#accordianContainer .collapse.show")).size());


    }

    @Test
    void section2Test(){

        assertEquals(1, driver.findElements(By.id("section2Content")).size());

        WebElement section2 = driver.findElement(By.id("section2Content"));
        assertFalse(section2.isDisplayed());
        assertTrue(driver.findElement(By.id("section1Content")).isDisplayed());

        WebElement heading2 = driver.findElement(By.id("section2Heading"));
        js.executeScript("arguments[0].scrollIntoView();", heading2);
        heading2.click();

        section2 = driver.findElement(By.id("section2Content"));
        assertTrue(section2.isDisplayed());

        //System.currentTimeMillis();
        //Boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("section1Content")));
        //Thread.sleep(3000L);

        assertFalse(driver.findElement(By.id("section1Content")).isDisplayed());


    }

}
