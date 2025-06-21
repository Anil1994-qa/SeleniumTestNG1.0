package HeadLess_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo_1 {
public static void main(String[] args) throws InterruptedException {
		
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--headless=new");
	
	WebDriver driver=new ChromeDriver(options);
	 driver.get("https://testautomationpractice.blogspot.com/");
	 WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	 
	String title=driver.getTitle();
	mywait.until(ExpectedConditions.elementToBeClickable(By.id("sunday"))).click();
	Thread.sleep(5000);
	if(title.equals("Automation Testing Practice"))
	{
		System.out.println("Test case is Passed");
	}
	else
	{
		System.out.println("Test case is Failed");

	}
	
	driver.quit();
	}

}
