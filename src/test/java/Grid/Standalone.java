package Grid;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Standalone {
public Properties p;
public WebDriver driver;
@Parameters({"os","br"})	
@Test
public void Gridstandalone(String os, String br) throws IOException
{
	FileReader file = new FileReader("./src/main/resources/Config.properties");
	p=new Properties();
	p.load(file);
	String env = p.getProperty("execution_env").trim();
	System.out.println("Execution Env: " + env);
	//remote
	if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		if(os.equalsIgnoreCase("windows"))
		{
		cap.setPlatform(Platform.WINDOWS);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			cap.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No Matching OS");
		}
		switch(br.toLowerCase())
		{
		case "chrome":cap.setBrowserName("chrome");
		break;
		case "edge":cap.setBrowserName("MicrosoftEdge");
		break;
		case "firefox":cap.setBrowserName("firefox");
		break;
		default:System.out.println("Invalid Browser");
		}
		driver=new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), cap);
	}
	
	
	//Local
	if (p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();
		break;
		case "edge":driver=new EdgeDriver();
		break;
		case "firefox":driver=new FirefoxDriver();
		break;
		default:System.out.println("Invalid Browser");
	   }
	}
     driver.get("https://testautomationpractice.blogspot.com/");
   String title= driver.getTitle();
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
