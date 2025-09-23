package com.tap.registration_testing.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/src/WebPage/Registration.html");
         wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      
    }
@Test
public void testLoginForm() {
    // Store first name in a variable before submitting
    String enteredFirstName = "Nayan";

    driver.findElement(By.id("fname")).sendKeys(enteredFirstName);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("lname")).sendKeys("Surve");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("email")).sendKeys("nayan@example.com");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("phone")).sendKeys("1234567891");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("username")).sendKeys("nayansurve");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("password")).sendKeys("12345678");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("cpassword")).sendKeys("12345678");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("gender")).sendKeys("female");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    driver.findElement(By.id("address")).sendKeys("A/P,Mangnoor");
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }

    // Click submit to navigate
    driver.findElement(By.id("submit")).click();
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }

    // Wait for the welcome message on the new page
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
    WebElement welcomeMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("msg")));

    // Assert that the welcome message contains the first name
    assertTrue(welcomeMessage.getText().contains("Welcome " + enteredFirstName));
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
}
    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
