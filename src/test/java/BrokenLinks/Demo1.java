package BrokenLinks;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
public static void main(String[] args) throws IOException {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
   List<WebElement> links=driver.findElements(By.tagName("a"));
   System.out.println("Total number of links :"+links.size());
   
   for(WebElement alinks:links)
   {
	   String hrefvalue=alinks.getAttribute("href");
	   if(hrefvalue==null || hrefvalue.isEmpty())
	   {
   		System.out.println("href value is empty or null So not possible to	to check :(");
		   continue;
	   }
	   try {
       URL url=new URL(hrefvalue);
       HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
       conn.connect();
       if(conn.getResponseCode()>=400)
       {
      		System.out.println("It's Broken Link :"+hrefvalue);
       }
       else
       {
    	   System.out.println("It's not Broken Link :"+hrefvalue);
       }
	   }
	   catch(Exception e)
	   {
		   e.getMessage();
	   }
	   
   }
	}

}
