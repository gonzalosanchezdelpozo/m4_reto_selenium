package com.example.demoqa;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://demoqua.com/text-box
 * Test
 * submitEmptyFormTest()
 * submitIncorrectEmailTest()
 * submitOkTest()
 */

public class CheckBoxTest {


    private static final String URL = "https://demoqa.com/checkbox";
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {

        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver();

    }


    @AfterEach
    void tearDown() {

        driver.quit();

    }

    @Test
    void submitEmptyFormTest(){

        driver.get("https://demoqa.com/text-box");
        assertEquals(1, driver.findElements(By.className("undefined")).size());

        System.out.println(driver.findElements(By.id("undefined")).size());

        WebElement button = driver.findElement(By.id("submit"));
        button.submit();
        assertEquals(1, driver.findElements(By.className("undefined")).size());



    }



}
