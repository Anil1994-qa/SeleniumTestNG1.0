package Dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_dropdowns {
public static void main(String[] args) {
		
	WebDriver driver=new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
	Select act=new Select(country);
	

	//Select the option from drop down---we have 3 methods in select object
	//act.selectByVisibleText("France");
    // act.selectByValue("canada"); //here the value is attribute in dev tool for that particular element
	// act.selectByIndex(8);
	
	//Capture all the option from the drop down
	 List<WebElement>options=act.getOptions();  // this will return all the options which are available in dropdown
	 System.out.println("Total Number of options avilable in the dropdown :"+options.size());
	 
	 //Print all the options from drop downs
	 
	 for(int i=0; i<options.size(); i++)
	 {
		 System.out.println(options.get(i).getText());
	 }
	 
	 
	}

}
