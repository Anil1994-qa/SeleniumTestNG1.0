package TakeScreenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FullPageSS {
public static void main(String[] args) {
		
	
	WebDriver driver =new FirefoxDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    TakesScreenshot ts=(TakesScreenshot)driver;
	File sourcefile= ts.getScreenshotAs(OutputType.FILE);
   
	//Resource file
    File targetfile=new File(System.getProperty("user.dir")+"//screenshots//FullPage.png");
     sourcefile.renameTo(targetfile);
     
     
	}

}
