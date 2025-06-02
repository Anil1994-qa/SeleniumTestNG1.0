package Dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BootStrap_dropDowns {
public static void main(String[] args) {
		
	WebDriver mydriver=new EdgeDriver();
	mydriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	mydriver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	
	
	mydriver.findElement(By.xpath("//b[@class='caret']")).click();
	
	//select single option
	mydriver.findElement(By.xpath("//input[@value=\"Oracle\"]")).click();
	
	
	//Find out all the options and print all of them
	List<WebElement>dropoptions=mydriver.findElements(By.xpath("//ul[@class=\"multiselect-container dropdown-menu\"]//label"));
	System.out.println("The total number of options avilable in the drop down :"  +dropoptions.size());
	
	//print all options
	for(WebElement op:dropoptions)
	{   
		String ap=op.getText();
		System.out.println(ap);
		if(ap.equals("C#") || ap.equals("Java") || ap.equals("MySQL") || ap.equals("Oracle")) 
		{
		
			op.click();
	    }
	}
	
	//Check if options are selected, if selected print they are selected
	
	
	
	}




}
