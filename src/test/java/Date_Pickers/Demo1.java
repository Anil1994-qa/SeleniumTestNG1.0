package Date_Pickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
public static void main(String[] args) {
		
	
	WebDriver driver =new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    //Switch to frame
    driver.switchTo().frame(0);
    //Click on date
    driver.findElement(By.xpath("//input[@id='datepicker']")).click();
    
    //Expected date
    String year="2027";
    String month="October";
    String date="27";
    
    while(true)
    {
    	String Actual_month=driver.findElement(By.xpath("//div[@class=\"ui-datepicker-title\"]//span[1]")).getText();
    	String Actual_year=driver.findElement(By.xpath("//div[@class=\"ui-datepicker-title\"]//span[2]")).getText();
    	if(Actual_month.equals(month)&& Actual_year.equals(year))
    	{
    		break;
    	}
    	//Click on next
    	driver.findElement(By.xpath("//a[@data-handler=\"next\"]")).click();
    }
    
    //Select Date
    List<WebElement> All_dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tr//td"));
    for(WebElement Expected_date:All_dates)
    {
    	if(Expected_date.getText().equals(date))
    	{
    		Expected_date.click();
    		break;
    	}
    }
	//driver.close();









}

}
