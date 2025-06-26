package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class DataProviderDemo {
WebDriver driver;
Actions act;
@BeforeClass
void Setup()
{
	driver=new ChromeDriver();	
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
}
@Test(dataProvider = "logindata")
void testLogin(String email, String Pwd) throws InterruptedException
{
	driver.get("https://tutorialsninja.com/demo/");
	act=new Actions(driver);
	WebElement My_Account=driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
	act.moveToElement(My_Account).click().build().perform();
	WebElement Login=driver.findElement(By.xpath("//a[normalize-space()='Login']"));
	act.moveToElement(Login).click().build().perform();
	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Pwd);
	driver.findElement(By.xpath("//input[@value='Login']")).click();
    boolean status=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
    Thread.sleep(2000);
    if(status==true)
    {
    	driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
    	Assert.assertTrue(true);
    }
    else
    {
    	Assert.fail();
    }
	
}
@AfterClass
void tearDown()	
{
	driver.close();	
}


@DataProvider(name="logindata")
public Object [][] loginData(){
	
	String Data[][]= {
			{"abc@gmail.com", "test123"},
			{"anilgowdan67@gmail.com","Anil@1122"},
			{"pavanol123@gmail.com", "test@123"},
			{"jhoncanedy@gmail.com","test"}
	};	
	return Data;
}

}
