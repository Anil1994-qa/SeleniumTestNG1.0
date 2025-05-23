import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
public static void main(String[] args) {
		
	
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("Shoes");
     List<WebElement>options=  driver.findElements(By.xpath("//ul[@class=\"_1sFryS _2x2Mmc _3ofZy1\"]/li/div//div[2]"));
     int count=options.size();
     System.out.println(count);
     for(WebElement op:options)
     {
    	 System.out.println(op.getText());;
     }
      options.get(count-4).click();
      
      driver.quit();
    
	}

}
