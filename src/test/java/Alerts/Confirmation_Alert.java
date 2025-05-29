package Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Confirmation_Alert {
public static void main(String[] args) {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
  //Click on simple alert
    driver.findElement(By.id("confirmBtn")).click();
    
    //Switch to alert
    Alert  myalert= driver.switchTo().alert();
    System.out.println(myalert.getText());
    myalert.dismiss();
    driver.quit();
    
    //Dismiss the alert
   // driver.switchTo().alert().dismiss();
  //Dismiss the alert
    // driver.switchTo().alert().dismiss();
  //Dismiss the alert
    // driver.switchTo().alert().dismiss();
  //Dismiss the alert
  //Dismiss the alert
    // driver.switchTo().alert().dismiss();
  //Dismiss the alert
    // driver.switchTo().alert().dismiss();
    // driver.switchTo().alert().dismiss();
    

	}

}
