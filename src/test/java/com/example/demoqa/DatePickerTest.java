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

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DatePickerTest {

    private static final String URL = "https://demoqa.com/date-picker";
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

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        String dateString = input.getAttribute("value");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        System.out.println(date.toString());
        System.out.println(LocalDate.now(), toString());

        assertEquals(date.toString(), LocalDate.now().toString());

    }

    @Test
    void selectDayTest() {

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        input.click();

        WebElement monthSelect = driver.findElement(By.className("react-datepicker__month-select"));
        monthSelect.click();

        WebElement MonthOption = driver.findElement(By.xpath("//select//option[@value ='0']"));
        MonthOption.click();

        WebElement yearSelect = driver.findElement(By.className("react-datepicker__year-select"));
        yearSelect.click();

        WebElement yearOption = driver.findElement(By.xpath("//select//option[@value='2021']"));
        yearOption.click();

        List<WebElement> days = driver.findElement(By.className("react-datepicker__day--001"));
        assertEquals(1, days.size() >= 1);
        days.get(0).click();

        input = driver.findElement(By.id("datePickerMonthYearInput"));
        String dateString = input.getAttribute("value");
        assertEquals("01/01/2021", dateString);

    }


    @Test
    void selectDateTimeTest() {

        WebElement input = driver.findElement(By.id("dateAndTimePickerInput"));
        input.click();

        WebElement time = driver.findElement(By.ByXPath("//li[text() = '09:00']"));
        time.click();

        input = driver.findElement(By.id("DateAndTimePickerInput"));
        String dateString = input.getAttribute("value");
        assertTrue(dateString.contains("9:00 AM"));

    }

}
