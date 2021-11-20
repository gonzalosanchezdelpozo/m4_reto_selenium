package com.example.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.List;

/**
 * https://demoqua.com/text-box
 * Test
 * submitEmptyFormTest()
 * submitIncorrectEmailTest()
 * submitOkTest()
 */
public class TextBoxTest {

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

    @Test
    void submitIncorrectEmailTest(){

        driver.get("https://demoqa.com/text-box");
        assertEquals(1, driver.findElements(By.className("undefined")).size());

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("prueba.com");

        WebElement button = driver.findElement(By.id("submit"));
        button.submit();

        assertEquals(1, driver.findElements(By.className("undefined")).size());

    }

    @Test
    void submitOkTest(){

        driver.get("https://demoqa.com/text-box");


        assertEquals(1, driver.findElements(By.className("undefined")).size());

        WebElement inputName = driver.findElement(By.id("userName"));
        inputName.sendKeys("Arsenio Selenio");

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("arsenioselenio@gmail.com");

        WebElement inputAddress = driver.findElement(By.id("currentAddress"));
        inputAddress.sendKeys("Plaza del Selenio");

        WebElement inputPermanent = driver.findElement(By.id("permanentAddress"));
        inputPermanent.sendKeys("Avenida del Selenio");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        assertEquals(0, driver.findElements(By.className("undefined")).size());

        WebElement name = driver.findElement(By.id("name"));
        assertTrue(name.getText().contains("Arsenio Selenio"));

        WebElement email = driver.findElement(By.id("email"));
        assertTrue(email.getText().contains("arsenioselenio@gmail.com"));

        List<WebElement> currents = driver.findElements(By.id("currentAddress"));
        WebElement lastCurrent = currents.get(currents.size() - 1);
        assertTrue(lastCurrent.getText().contains("Plaza del Selenio"));

        WebElement lastPermanent = driver.findElement(By.cssSelector("#output #permanentAddress"));
        assertTrue(lastPermanent.getText().contains("Avenida del Selenio"));


    }

}
