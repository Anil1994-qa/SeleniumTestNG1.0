package WebDriverMethods;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {
public static void main(String[] args) {
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
    
    mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick=\"myFunction()\"]"))).click();
    
  Set<String> windowhandles= driver.getWindowHandles();
  Iterator <String>it=windowhandles.iterator();
  /*
  while(it.hasNext())
  {
	  System.out.println(it.next());
  }
  */
  String parent=it.next();
  driver.switchTo().window(parent);
 String parent_titel=driver.getTitle();
 System.out.println(parent_titel);

  String child=it.next();
 driver.switchTo().window(child);
 String child_titel=driver.getTitle();
 System.out.println(child_titel);

 driver.quit();
  
	}

}
