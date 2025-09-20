import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
public static void main(String[] args) {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");	
 	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	
 	
   WebElement search_bar=driver.findElement(By.id("twotabsearchtextbox"));
	search_bar.sendKeys("mobiles");
	//driver.findElement(By.id("nav-search-submit-button")).click();
	
	//Scroll Twice
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(0,1000)");
	List<WebElement> dropdown= driver.findElements(By.xpath("//div[@class=\"two-pane-results-container\"]/div/div/div"));
	 int count=dropdown.size();
	 for(WebElement op:dropdown)
	 {
    	 System.out.println(op.getText());

	 }
	 dropdown.get(count-5).click();
	 driver.quit();
	}

}
