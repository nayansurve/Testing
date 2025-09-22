package com.tap.testing.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
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

public class Login_Test {
    private static WebDriver driver;

   @BeforeAll

  static void setup()
  {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("http://127.0.0.1:5500/src/WebPages/Login.html?username=&password=&textbox=");
  }

  @Test
  void testLoginForms() {
    WebElement username = driver.findElement(By.id("username"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement submit = driver.findElement(By.id("submit"));
   // WebElement textbox = driver.findElement(By.id("textbox"));

    username.sendKeys("naina08@example.com");
 
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        System.out.println(e);
    }
    password.sendKeys("password");
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        System.out.println(e);
    }


    String enteredUser = username.getAttribute("value");
    String enteredPass = password.getAttribute("value");


    submit.click();
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        System.out.println(e);
    }


     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
     WebElement message=wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("textbox"))
        
     );
    if(enteredUser.equals("naina08@example.com")&&enteredPass.equals("password"))
    {
        message.sendKeys("Login Successful");
    }
    else
    {
        message.sendKeys("Login UnSucceful");
    }
    assertTrue(message.getAttribute("value").contains("Login Successful"));
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        System.out.println(e);
    }
  }
  @AfterAll
  static void teardown()
  {
    if(driver != null)
    {
        driver.quit();
    }
  }

}
