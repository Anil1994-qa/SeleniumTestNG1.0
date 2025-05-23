package Date_Pickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDatePickers {
	

	public static void SelectFutureDate(WebDriver driver,String year, String month, String day)
	{
		while(true)
		{
			String Actual_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String Actual_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(Actual_year.equals(year) && Actual_month.equals(month))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement>dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tr//td"));
		for(WebElement alldates:dates)
		{
			if(alldates.getText().equals(day))
			{
				alldates.click();
				break;
			}
		}
		
	}
		
public void SelectPastDate(WebDriver driver, String year, String month, String day) {
		
			while(true)
			{
				String Actual_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				String Actual_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				if(Actual_year.equals(year) && Actual_month.equals(month))
				{
					break;
				}
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			List<WebElement>dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tr//td"));
			for(WebElement alldates:dates)
			{
				if(alldates.getText().equals(day))
				{
					alldates.click();
					break;
				}
			}
	}

public static void main(String[]args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.switchTo().frame(0);//--Since we only one frame in the web page
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();

	String year="2027";
	String month="June";
	String date="5";
	//SelectFutureDate(driver,"2027","June","5");
	SelectFutureDate(driver, year, month, date);
	
	
	
	
	
}
}

