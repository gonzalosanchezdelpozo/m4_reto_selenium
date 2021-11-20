package com.example.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonsTest {

    private static final String URL = "https://demoqa.com/buttons";
    WebDriver driver;
    JavascriptExecutor js;


    @BeforeEach
    void setUp() {
        String dir = System.getProperty("user.dir"); // ruta del proyecto
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver(); // Google Chrome

        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    void tearDown() {

        driver.quit();
    }

    @Test
    void doubleClickTest(){

        assertEquals(0, driver.findElements(By.id("doubleClickMessage")).size());
        WebElement button = driver.findElement(By.id("doubleClickBtn"));
        Actions action  = new Actions (driver);
        action.doubleClick(button).perform();


        //button.click();
        //button.click();

        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        assertEquals("You have done a double click", message.getText());



    }

    @Test
    void clickTest(){

        assertEquals(0, driver.findElements(By.id("dynamicClickMessage")).size());
        WebElement button = driver.findElement(By.xpath("//button[text() = 'Click Me']"));

        button.click();

        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        assertEquals("You have done a dynamic click", message.getText());


    }


}
