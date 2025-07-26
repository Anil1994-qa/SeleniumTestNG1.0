package Grouping;

import org.testng.annotations.Test;

public class SanityNFunction {
	@Test(groups={"Regression","Function"})
	public void m1()
	{
		System.out.println("This is SanityNFunction group m1 method");
	}
	@Test(groups={"Regression","Function"})
	public void m2()
	{
		System.out.println("This is SanityNFunction group m2 method");	
	}
	@Test(groups={"Regression","Function"})
	public void m3()
	{
		System.out.println("This is SanityNFunction group m3 method");
	}
}
