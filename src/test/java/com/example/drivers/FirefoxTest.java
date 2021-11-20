package com.example.drivers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

public class FirefoxTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {

        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/geckodriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.gecko.driver", url);
        driver = new FirefoxDriver();

    }

    @AfterEach
    void tearDown() {

        driver.quit();

    }

    @Test
    void Test1(){
        driver.get("https://elpais.com");
        String title = driver.getTitle();
        assertEquals("EL PAÍS: el periódico global", title);
    }

    @Test
    void Test2(){
        driver.get("https://eldiario.es");
        String title = driver.getTitle();
        assertEquals("elDiario.es - Noticias de actualidad - Periodismo a pesar de todo", title);
    }


}
