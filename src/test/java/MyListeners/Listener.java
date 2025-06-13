package MyListeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener{
  static WebDriver driver;
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test Case is Passed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source_file=ts.getScreenshotAs(OutputType.FILE);
		File target_file=new File(System.getProperty("user.dir")+"//screenshots//TestPass"+Math.random()+"png");
		//source_file.renameTo(target_file);
		try 
		{
			FileHandler.copy(source_file, target_file);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test Case is Failed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source_file=ts.getScreenshotAs(OutputType.FILE);
		File target_file=new File(System.getProperty("user.dir")+"//screenshots//TestFail"+Math.random()+"png");
		//source_file.renameTo(target_file);
		try 
		{
			FileHandler.copy(source_file, target_file);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
