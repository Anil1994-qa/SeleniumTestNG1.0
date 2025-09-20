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

public class Demo4 {
public static void main(String[] args) throws IOException {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
    List<WebElement> links=driver.findElements(By.tagName("a"));
    System.out.println(links.size());
    for(WebElement allinks:links)
    {
    	String href=allinks.getAttribute("href");
    	if(href==null || href.isEmpty())
    	{
    		System.out.println("The Link is Broken Unable to check");
    		continue;
    	}
    	URL url=new URL(href);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	conn.connect();
        if(conn.getResponseCode()>=400)
          {
    		System.out.println(url+"- It's a broken Link");
          }
         else
          {
    		System.out.println(url+" - It's not a broken Link");
          } 
    }
         driver.quit();
	}

}
