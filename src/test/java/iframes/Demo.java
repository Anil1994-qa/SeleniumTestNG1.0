package iframes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
public static void main(String[] args) {
		
	WebDriver driver=new ChromeDriver();
	driver.get("https://ui.vision/demo/webtest/frames");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	//switch to frame 1
	WebElement frame_1=driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
	driver.switchTo().frame(frame_1);
	
	driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Anil Kumar N");
	driver.switchTo().defaultContent();
	
	//Switch to frame 2
	WebElement frame_2=driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
	driver.switchTo().frame(frame_2);
	driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("NavyaShree R");
    driver.switchTo().defaultContent();
    
    
    //switch to frame 3
    WebElement frame_3=driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
    driver.switchTo().frame(frame_3);
    driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Jai Shree Raam");
    //This frame has another frame inside it, switch to do operations
   WebElement iframe=driver.findElement(By.xpath("//iframe[@frameborder=\"0\"]"));
    driver.switchTo().frame(iframe);
    
   List<WebElement> checkboxes= driver.findElements(By.xpath("//div[@class=\"AB7Lab Id5V1\"]"));
   int count=checkboxes.size();
   checkboxes.get(count-1).click();
   
   List<WebElement> checkboxes_1=driver.findElements(By.xpath("//div[@class=\"uHMk6b fsHoPb\"]"));
   int count1=checkboxes_1.size();
   System.out.println(checkboxes_1);
   checkboxes.get(count1-1).click();
   
   driver.findElement(By.xpath("//div[@jsname=\"LgbsSe\"]")).click();
   
  List<WebElement> dropdowns=driver.findElements(By.xpath("//div[@class=\"OA0qNb ncFHed QXL7Te\"]//div[@role=\"option\"]"));
  for(WebElement op:dropdowns)
  {
	  if(op.getText().equals("Yes"))
	  {
		  op.click();
	  }
  }
   driver.switchTo().defaultContent();
   
   //switch to frame 4
   WebElement frame_4=driver.findElement(By.xpath("//frame[@src=\"frame_4.html\"]"));
   driver.switchTo().frame(frame_4);
   driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Hanuman");
   driver.switchTo().defaultContent();
   
   //switch to frame 5
   WebElement frame_5=driver.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
   driver.switchTo().frame(frame_5);
   driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Jai bhajarangi");
   
   driver.quit();
   
   

	}

}
