package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
public static void main(String[] args) throws IOException {
		int totalbl=0;
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    List<WebElement> links=driver.findElements(By.tagName("a"));
    System.out.println("Total number of links in the web Page"+links.size());
    
    for(WebElement all_links:links)
    	
    {
    	String hrefvalue=all_links.getAttribute("href");
    	if (hrefvalue == null || hrefvalue.isEmpty())
    	{
    		System.out.println("href value is empty or null So not possible to	to check :(");
			continue;  
    	}
    	
    	URL url=new URL(hrefvalue);//converted href value from string to URL format
    	HttpURLConnection conn=(HttpURLConnection) url.openConnection();
    	conn.connect();
    	try
    	{
    	if(conn.getResponseCode()>=400)
    	{
    		System.out.println(hrefvalue+"------>It's Broken Link");
    		totalbl++;
    	}
    	 else
		 {
			System.out.println(hrefvalue+"------>Not a Broken link");
		 }
    	}
    	catch(Exception e)
    	{
          System.out.println(hrefvalue + " ------> Exception occurred: " + e.getMessage());
    	}
    }
    System.out.println("Number of broken links"+totalbl);
    driver.close();
	}
}
