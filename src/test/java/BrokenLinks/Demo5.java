package BrokenLinks;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.net.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo5 {
public static void main(String[] args) throws IOException {

	WebDriver driver=new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Find all the available links
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("Total number of links :"+links.size());
	
	for(WebElement all_links:links)
	{
		String href=all_links.getAttribute("href");
		if(href==null  || href.isEmpty())
		{
			System.out.println("Links are broken not avilable to check");
			continue;
		}
		 URL url=new URL(href);
		 HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		 conn.connect();
		 if(conn.getResponseCode()>=400)
		 {
			 System.out.println("It's Broken Link :"+url);
		 }
		 else
		 {
			 System.out.println("It's not broken Link :"+url);

		 }
	}
	    
	}

}

