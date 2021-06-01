package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import org.openqa.selenium.support.ui.Select;

public class TestDelSubject extends TestDriver {
	ChromeDriver driver = getDriver();

//    @Test
//    public void DelSubTest(){
//        driver.get("http://localhost:8080/Sql_Project");
//        WebElement username = driver.findElement(By.id("account"));
//        username.sendKeys("son");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("123");
//        driver.findElement(By.id("submit")).click();
//        Select semester = new Select(driver.findElement(By.id("semester")));
//        semester.selectByIndex(1);
//        driver.findElement(By.id("submit")).click();
//        driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[2]/td[10]")).click();;
//        
//      
//        String title = driver.getTitle();
//        driver.close();
//      
//    }
    @Test
    public void DelSubTest_exsist(){
        driver.get("http://localhost:8080/Sql_Project");
        WebElement username = driver.findElement(By.id("account"));
        username.sendKeys("son");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        driver.findElement(By.id("submit")).click();
        Select semester = new Select(driver.findElement(By.id("semester")));
        semester.selectByIndex(1);
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[2]/td[10]")).click();;
        
      
       
        driver.close();
      
    }
    
    
}
