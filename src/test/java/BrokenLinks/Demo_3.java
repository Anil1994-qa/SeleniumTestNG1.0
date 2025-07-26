package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_3 {
public static void main(String[] args) throws IOException {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    List<WebElement> all_links=driver.findElements(By.tagName("a"));
    System.out.println(all_links.size());
    for(WebElement links:all_links)
    {
        String href_value=links.getAttribute("href");
        if(href_value == null || href_value.isEmpty())
        {
            System.out.println("href values are empty not able to check");
        	continue;
        }
          try
          {
          URL url=new URL(href_value);
      	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
          conn.connect();
          if(conn.getResponseCode()>=400)
          {
        	  System.out.println(href_value+"------>It's a broken link");
          }
          else
          {
        	  System.out.println(href_value+"------->It's not a broken link");
          }
          }
          catch(Exception e)
          {
        	  System.out.println(href_value + " ------> Exception occurred: " +e.getMessage());
          }
    }
    driver.close();
	}

}
