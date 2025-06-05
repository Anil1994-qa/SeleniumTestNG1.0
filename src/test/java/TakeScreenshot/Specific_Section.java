package TakeScreenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Specific_Section {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   WebElement webtable=driver.findElement(By.xpath("//div[@id='HTML1']"));
	   File s_file= webtable.getScreenshotAs(OutputType.FILE);
	  
	  File t_file=new File(System.getProperty("user.dir")+"//screenshots//Specific_Section.png");
	  s_file.renameTo(t_file);

	}

}
