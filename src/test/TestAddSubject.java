package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import org.openqa.selenium.support.ui.Select;

public class TestAddSubject extends TestDriver {
	ChromeDriver driver = getDriver();
//AddSubTest
    @Test
    public void AddSubTest(){
        driver.get("http://localhost:8080/Sql_Project");
        WebElement username = driver.findElement(By.id("account"));
        username.sendKeys("son");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        driver.findElement(By.id("submit")).click();
        Select semester = new Select(driver.findElement(By.id("semester")));
        semester.selectByIndex(1);
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[3]/td[9]")).click();;
        
        String expectedTitle = "Quản lý đăng ký tín chỉ ";
        String title = driver.getTitle();
        driver.close();
        assertEquals(expectedTitle, title, "Quản lý đăng ký tín chỉ");
    }
 

        @Test
        public void AddSubTest_Same(){
            driver.get("http://localhost:8080/Sql_Project");
            WebElement username = driver.findElement(By.id("account"));
            username.sendKeys("son");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("123");
            driver.findElement(By.id("submit")).click();
            Select semester = new Select(driver.findElement(By.id("semester")));
            semester.selectByIndex(1);
            driver.findElement(By.id("submit")).click();
            driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[2]/td[9]")).click();;
            
            
           
            
            String expectedTitle = "Thêm không thành công";
            String title = driver.findElement(By.xpath("/html/body/h2[1]")).getText();
            driver.close();
            assertEquals(expectedTitle, title, "Thêm không thành công");
        
    }
    
}
