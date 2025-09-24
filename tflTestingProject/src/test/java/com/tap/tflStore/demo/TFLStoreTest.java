package com.tap.tflStore.demo;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TFLStoreTest {
    private static WebDriver driver;
   //before the method run 
    @BeforeAll
    static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://localhost:8000/index.html");
    }
    @Test
    void testtflstore()
    {
        WebElement gallery = driver.findElement(By.id("galleryLink"));
        gallery.click();
        String afterclickgallery = driver.getCurrentUrl();
        assertTrue(afterclickgallery.contains("catalog.html"), afterclickgallery);
         try{
        Thread.sleep(2000); 
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
       
        WebElement rosebtn=driver.findElement(By.id("8"));
        rosebtn.click();
        String afterclickrose = driver.getCurrentUrl();
        assertTrue(afterclickrose.contains("details.html"), afterclickrose);
        try
        {
        Thread.sleep(2000); 
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
       
        WebElement Addcartbtn=driver.findElement(By.id("cart"));
        Addcartbtn.click();
        String addcart=driver.getCurrentUrl();
        assertTrue(addcart.contains("cart.html"),addcart);    
        try{
        Thread.sleep(2000); 
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }

        WebElement productidentifier=driver.findElement(By.id("txtid"));
        productidentifier.sendKeys("9");
        try{
        Thread.sleep(2000); 
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
            }
        WebElement productquantity=driver.findElement(By.id("txtquantity"));
        productquantity.sendKeys("10");
     try{
        Thread.sleep(2000); 
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    
        WebElement addtocartbtn=driver.findElement(By.id("addtocartc"));
        addtocartbtn.click();
        try{
        Thread.sleep(2000); 
        }
        catch(InterruptedException e){
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
