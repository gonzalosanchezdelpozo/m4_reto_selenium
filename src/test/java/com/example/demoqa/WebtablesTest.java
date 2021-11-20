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
 * https://demoqua.com/web-tables
 * Test
 * submitEmptyFormTest()
 * submitIncorrectEmailTest()
 * submitOkTest()
 */

public class WebtablesTest {

    private static final String URL = "https://demoqa.com/webtables";
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {

        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver();
        driver.get(URL);

    }


    @AfterEach
    void tearDown() {

        driver.quit();

    }

    @Test
    void deleteElementTest() {
    //     driver.get(URL);
        assertEquals(3,  driver.findElements(By.className("action-buttons")).size());

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//span[contains(@id, 'delete-record-')]"));
   //   List<WebElement> deleteButtons = driver.findElements(By.xpath("//span[@title='Delete']"));
   //   List<WebElement> deleteButtons = driver.findElements(By.cssSelector("span[id*='delete-record-']"));

    /*    deleteButtons.get(0).click();
        assertEquals(2,  driver.findElements(By.className("action-buttons")).size());

        deleteButtons = driver.findElements(By.xpath("//span[contains(@id, 'delete-record-')]"));
        deleteButtons.get(0).click();
        assertEquals(1,  driver.findElements(By.className("action-buttons")).size());

        deleteButtons = driver.findElements(By.xpath("//span[contains(@id, 'delete-record-')]"));
        deleteButtons.get(0).click();

        assertEquals(0,  driver.findElements(By.className("action-buttons")).size()); */

        for(int i = deleteButtons.size(); i>0; i--){

            deleteButtons = driver.findElements(By.xpath("//span[contains(@id, 'delete-record-')]"));
            deleteButtons.get(0).click();
            assertEquals(i - 1,  driver.findElements(By.className("action-buttons")).size());

        }

    }

    @Test
    void searchTest(){

    //    driver.get(URL);
          assertEquals( 3, driver.findElements(By.className("action-buttons")).size());
          WebElement search = driver.findElement(By.id("searchBox"));
          search.sendKeys("Test");
          assertEquals( 0, driver.findElements(By.className("action-buttons")).size());


    }

    @Test
    void submitEmptyFormTest(){

        driver.findElement(By.id("addNewRecordButton")).click();

        assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());

        WebElement button = driver.findElement(By.id("submit"));
        js.executeScript("arguments [0].scrollIntoView();", button);
        button.click();

        assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());

    }

    @Test
    void nameLengtTest()
    {

        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.id("firstName")).sendKeys("dloeltñeobhuowqpmdrowlaehuote");

        assertEquals(25, driver.findElement(By.id("firstName")).getAttribute("value").length());

        //assertEquals("dloeltñeobhuowqpmdrowlaehuote", driver.findElement(By.id("firstName")).getAttribute("value"));


    }

    @Test
    void adOkTest() {

        assertEquals( 3, driver.findElements(By.className("action-buttons")).size());
        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.id("firstName")).sendKeys("Arsenio");
        driver.findElement(By.id("lastName")).sendKeys("Selenio");
        driver.findElement(By.id("userEmail")).sendKeys("arsenioselenio@gmail.com");
        driver.findElement(By.id("age")).sendKeys("34");
        driver.findElement(By.id("salary")).sendKeys("40.000 €");
        driver.findElement(By.id("department")).sendKeys("Desarrollo");

        WebElement button = driver.findElement(By.id("submit"));
        js.executeScript("arguments [0].scrollIntoView();", button);
        button.click();

        assertEquals( 4, driver.findElements(By.className("action-buttons")).size());
    }

    @Test
    void editRowTest() {

        List<WebElement> editButtons = driver.findElements(By.xpath("//span[contains(@id, 'edit-record-')]"));
        editButtons.get(0).click();
        assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());

        assertEquals("Cierra", driver.findElement(By.id("firstName")).getAttribute("value"));
        assertEquals("Vega", driver.findElement(By.id("LastName")).getAttribute("value"));
        assertEquals("cierra@example.com", driver.findElement(By.id("firstName")).getAttribute("value"));
        assertEquals("Cierra", driver.findElement(By.id("userEmail")).getAttribute("value"));
        assertEquals("39", driver.findElement(By.id("age")).getAttribute("value"));
        assertEquals("10000", driver.findElement(By.id("salary")).getAttribute("value"));
        assertEquals("Insurance", driver.findElement(By.id("department")).getAttribute("value"));


    }

    @Test
    void closeModal() {

        driver.findElement(By.id("addNewRecordButton")).click();
        assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());
        driver.findElement(By.className("close")).click();
        assertEquals(0, driver.findElements(By.className("model-content")).size());


    }

    @Test
    void paginationTest() {

        assertEquals( 10, driver.findElements(By.className("rt-tr-group")).size());

        //driver.findElements(By.className("rt-tr-group")).size();
        WebElement selector = driver.findElement(By.cssSelector(".pagination-bottom select"));
        js.executeScript("arguments [0].scrollIntoView();", selector);
        selector.click();

        WebElement option20 = driver.findElement(By.cssSelector(".pagination-bottom select option[value='20']"));
        option20.click();

        assertEquals( 20, driver.findElements(By.className("rt-tr-group")).size());


    }


}
