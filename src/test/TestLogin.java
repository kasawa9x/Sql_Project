package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin extends TestDriver {
	ChromeDriver driver = getDriver();

    @Test
    public void loginTest(){
        driver.get("http://localhost:8080/Sql_Project");
        String title = driver.getTitle();
        String expectedTitle = "Quản lý đăng ký tín chỉ ";
        driver.close();
        assertEquals(expectedTitle, title, "Quản lý đăng ký tín chỉ");
    }
    @Test
    public void CheckLogin(){
        driver.get("http://localhost:8080/Sql_Project");
        WebElement username = driver.findElement(By.id("account"));
        username.sendKeys("son");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        driver.findElement(By.id("submit")).click();
        String expectedTitle = "Quản lý đăng ký tín chỉ ";
        String title = driver.getTitle();
        driver.close();
        assertEquals(expectedTitle, title, "Quản lý đăng ký tín chỉ");
    }
	
    @Test
    public void CheckLogin_Fail(){
        driver.get("http://localhost:8080/Sql_Project");
        WebElement username = driver.findElement(By.id("account"));
        username.sendKeys("son");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1");
        driver.findElement(By.id("submit")).click();
        WebElement tb = driver.findElementByXPath("/html/body/div[1]/form/text()");
        String expectedTitle = "Sai tên đăng nhập hoặc mật khẩu ";
        String title = driver.getTitle();
        driver.close();
        assertEquals(expectedTitle, tb, "Sai tên đăng nhập hoặc mật khẩu");
    }

    
    
}
