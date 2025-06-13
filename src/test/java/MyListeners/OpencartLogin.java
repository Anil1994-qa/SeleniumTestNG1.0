package MyListeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class OpencartLogin extends Listener{
	@Test
	public void verifylogin()
	{
		driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("anilgowdan67@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Anil@1122");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
        String SuccessfullMsg=driver.getTitle();
        Assert.assertEquals("My Account", SuccessfullMsg,"Test Case Got failed");
        //driver.quit();
	}

}
