package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.protocol.Message;

public class TestLogUp extends TestDriver {
	ChromeDriver driver = getDriver();
  @Test
  public void CheckLogUp(){
      driver.get("http://localhost:8080/Sql_Project");
      driver.findElement(By.id("logup")).click();
      WebElement id = driver.findElement(By.id("id"));
      id.sendKeys("SV98");
      WebElement username = driver.findElement(By.id("account"));
      username.sendKeys("yxz");
      WebElement password = driver.findElement(By.id("password"));
      password.sendKeys("123");
      WebElement name = driver.findElement(By.id("name"));
      name.sendKeys("N T X");
      driver.findElement(By.id("logup")).click();
      String expectedTitle = "Quản lý đăng ký tín chỉ ";
      String title = driver.getTitle();
      driver.close();
      assertEquals(expectedTitle, title, "Quản lý đăng ký tín chỉ");
  }

  @Test
  public void CheckLogUp_Fail(){
      driver.get("http://localhost:8080/Sql_Project");
      driver.findElement(By.id("logup")).click();
      WebElement id = driver.findElement(By.id("id"));
      id.sendKeys("SV99");
      WebElement username = driver.findElement(By.id("account"));
      username.sendKeys("xyz");
      WebElement password = driver.findElement(By.id("password"));
      password.sendKeys("");
      WebElement name = driver.findElement(By.id("name"));
      name.sendKeys("N T X");
      driver.findElement(By.id("logup")).click();
      WebElement noti = driver.findElement(By.linkText("Cần nhập đủ các trường"));
      driver.close();
      
      assertEquals(noti.getText(), "Cần nhập đủ các trường");
  }
    
    
}
