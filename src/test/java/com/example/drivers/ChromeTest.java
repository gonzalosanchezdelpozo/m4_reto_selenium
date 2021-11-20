package com.example.drivers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChromeTest {

    WebDriver driver;

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
    void Test1(){
        driver.get("https://elpais.com");
        String title = driver.getTitle();
        assertEquals("EL PAÍS: el periódico global", title);
    }

    @Test
    void TestInputForm(){
        driver.get("https://seleniumbase.io/demo_page");
        WebElement input = driver.findElement(By.id("myTextInput"));
        input.sendKeys("Esto es un texto enviado desde Selenium");
        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
        void ValidateTestInputForm(){
        driver.get("https://seleniumbase.io/demo_page");
        WebElement input = driver.findElement(By.id("myTextInput"));
        input.sendKeys("Esto es un texto enviado desde Selenium");
        String inputValue = input.getAttribute("value");
        assertEquals("Esto es un texto enviado desde Selenium", inputValue);

    }

    @Test
    void TestSearchDuckduckgo(){
        driver.get("https://duckduckgo.com/");
        WebElement input =  driver.findElement(By.name("q"));
        input.clear();
        input.sendKeys("Elección miembros tribunal constitucional" + Keys.ENTER);
        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testSearchGoogle(){
        driver.get("https://www.google.es/");
        WebElement acceptButton =  driver.findElement(By.xpath("//div[text() = 'Acepto']"));
        assertEquals("jyfHyd", acceptButton.getAttribute("class"));
        acceptButton.getAttribute("class");
        WebElement input =  driver.findElement(By.name("q"));
        input.sendKeys("cabalgata de reyes bilbao");
        input.submit();
    }

    @Test
    void testDropDown(){
        driver.get("https://seleniumbase.io/demo_page");
        WebElement selector =  driver.findElement(By.id("mySelect"));
        selector.click();

        List <WebElement> options = driver.findElements(By.cssSelector("#mySelect option"));
        assertEquals(4, options.size());
        options.get(3).click();

      //  WebElement option = driver.findElement(By.xpath("//select[@id='mySelect']/option[@value='100%']"));
      //  assertEquals(4, options.size());
      //  options.get(3).click();

    }

    @Test
    void Test2(){
        driver.get("https://eldiario.es");
        String title = driver.getTitle();
        assertEquals("elDiario.es - Noticias de actualidad - Periodismo a pesar de todo", title);
    }

    @Test
    void TagNameSelector(){
        driver.get("https://www.eldiario.es/sociedad/presion-productores-mantener-ayudas-petroleo-obliga-prorrogar-cumbre-glasgow_1_8485636.html");

        WebElement h1 = driver.findElement(By.tagName("h1"));
        String h1Text = h1.getText();
        assertEquals("La presión de los productores para mantener las ayudas al petróleo obliga a prorrogar la cumbre de Glasgow", h1Text);


    }

    @Test
    void IdSelector(){
        driver.get("https://github.com/mozilla");
        WebElement repositories = driver.findElement(By.id("org-profile-repositories"));
        assertTrue(repositories.isDisplayed());
        String css = repositories.getAttribute("class");
        assertEquals("mb-3", css);

    }

    @Test
    void ClassSelector(){
        driver.get("https://github.com/mozilla");
        List<WebElement> repositories = driver.findElements(By.className("Box-row"));
        assertEquals(10, repositories.size());


    }

    @Test
    void cssSelector(){
        driver.get("https://github.com/mozilla");
        List<WebElement> topics = driver.findElements(By.cssSelector(".topic-tag.topic-tag-link"));
        assertEquals(5, topics.size());

    }

}
