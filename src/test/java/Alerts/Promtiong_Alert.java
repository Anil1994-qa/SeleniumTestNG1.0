package Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Promtiong_Alert {
public static void main(String[] args) {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
  //Click on simple alert
    driver.findElement(By.id("promptBtn")).click();
    
    //Switch to alert
    Alert  myalert= driver.switchTo().alert();
   // myalert.accept();
     myalert.dismiss();
    
    String Accept_msg =driver.findElement(By.id("demo")).getText();
    System.out.println(Accept_msg);
    if(Accept_msg.equals("Hello Harry Potter! How are you today?"))
    {
    	System.out.println("Alert Message is captured and Accepted sucessfully");
    }
    else if(Accept_msg.equals("User cancelled the prompt."))
    {
    	System.out.println("Alert Message is captured and Cancelled sucessfully");
    }
   
    driver.quit();
    
	
	}

}
