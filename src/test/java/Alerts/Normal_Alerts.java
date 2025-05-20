package Alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Normal_Alerts {
public static void main(String[] args) {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    //Click on simple alert
    driver.findElement(By.id("alertBtn")).click();
    
    //Switch to alert
    driver.switchTo().alert().accept();
  

	}

}
