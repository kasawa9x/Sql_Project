package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestDriver {
    private String driverUrl = "C:\\Users\\Admin\\Desktop\\chromedriver.exe";

    public TestDriver() {
    }

    public ChromeDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",driverUrl);
        return new ChromeDriver();
    }


	

}
