package FileUpload;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleFileUpload {
public static void main(String[] args) {
	
	WebDriver driver =new ChromeDriver();
	WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	mywait.pollingEvery(Duration.ofSeconds(5));

	}

}
